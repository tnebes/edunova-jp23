package IO;

import dataClasses.Address;
import dataClasses.Article;
import dataHandler.Controller;

import javax.naming.ldap.Control;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SQLCommunicator {

    // add ability to pull from SQL

    private static Connection connection;
    private static final String databaseName = "final_project_store_database";
    private static final int CUSTOMERS = 0;
    private static final int ADDRESSES = 1;
    private static final int INVOICES = 2;
    private static final int ARTICLES = 3;

    public static void initialise() {
        connection = createConnection();
        try {
            System.out.printf("Successfully connected to %s %s at %s .\n",
                    connection.getMetaData().getDatabaseProductName(),
                    connection.getMetaData().getDatabaseMajorVersion(),
                    connection.getMetaData().getURL());
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static Connection createConnection() {
        Connection myConnection = null;
        String connectionData;
        try {
            connectionData = DataIO.getSQLConnectionData();
            if (connectionData.isBlank()) {
                System.out.print("SQL connection data is blank. Exiting...\n");
                System.exit(1);
            }
            StringTokenizer tk = new StringTokenizer(connectionData);
            Class.forName("org.mariadb.jdbc.Driver");
            myConnection = DriverManager.getConnection(tk.nextToken(),
                    tk.nextToken(),
                    tk.nextToken());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return myConnection;
    }

    private static ResultSet sendQuery(String query) {
        //TODO check if string contains "drop database"
        ResultSet resultSet;
        try {
            Statement myStatement = connection.createStatement();
            resultSet = myStatement.executeQuery(query);
            return resultSet;
        } catch (SQLTransientConnectionException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            // connection = createConnection();
            System.exit(1);
            return null;
        }
    }

    public static ResultSet getSQLItems(int entity) {
        switch (entity) {
            case CUSTOMERS: return sendQuery("SELECT * FROM customer;");
            case ADDRESSES: return sendQuery("SELECT * FROM address;");
            case INVOICES: return sendQuery("SELECT * FROM invoice;");
            case ARTICLES: return sendQuery("SELECT * FROM article;");
            default: System.out.print("Wrong.\n");
            return null;
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void updateSQLDatabase() {
        // TODO article_invoice
        // TODO article
        updateArticles();
        // TODO invoice
        // TODO customer
        // TODO status
        // TODO transaction_type
        updateAddresses();

    }

    private static String parseDataAsString(String data) {
        if (data == null || data.isBlank()) {
            return null;
        }
        return "" + "'" + data + "'";
    }

    private static void updateArticles() {
        sendQuery("DELETE FROM articles");
        for (dataClasses.Article article : Controller.getArticles()) {
            sendQuery(sendArticlesToDB(article));
        }
    }

    private static String sendArticlesToDB(Article article) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO article VALUES (");
        //sb.append() // TODO CONTINUE
        return null;
    }

    private static String sendAddressToDB(dataClasses.Address address) {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO address VALUES (");
        sb.append(address.getId()).append(",");
        sb.append(address.isType() ? "1" : "0").append(",");
        sb.append(parseDataAsString(address.getCity())).append(",");
        sb.append(parseDataAsString(address.getZIPCode())).append(",");
        sb.append(parseDataAsString(address.getStreet())).append(",");
        sb.append(parseDataAsString(address.getStreetNumber())).append(",");
        sb.append(parseDataAsString(address.getStreetLetter())).append(",");
        sb.append(parseDataAsString(address.getCountry())).append(");");
        System.out.println(sb.toString());
        return sb.toString();
    }

    private static void updateAddresses() {
        sendQuery("DELETE FROM address");
        for (dataClasses.Address address : Controller.getAddresses()) {
            sendQuery(sendAddressToDB(address));
        }
    }

    /**
     * Retrieves all data from SQL database. Updates counters when necessary.
     */
    public static void updateLocalDataFromDB() {
        getAddresses();
        long maxCounter = 0;
        for (Address address : Controller.getAddresses()) {
            if(address.getId() > maxCounter) {
                maxCounter = address.getId();
            }
        }
        if (IDCounter.getAddressCounter() != maxCounter) {
            IDCounter.setAddressCounter(maxCounter);
        }
        // TODO customer
        // TODO transaction_type
        // TODO status
        // TODO invoice
        // TODO article
        // TODO article_invoice

        // TODO associate data with other data (invoices to customers, etc.)

        DataIO.writeDataToFiles();
    }

    private static void getAddresses() {
        ResultSet resultSet = getSQLItems(ADDRESSES);
        ArrayList<Address> tempAddress = new ArrayList<>();
        try {
            int counter;
            while (resultSet.next()) {
                counter = 1;
                tempAddress.add(new Address(
                        resultSet.getInt(counter++),
                        resultSet.getBoolean(counter++),
                        resultSet.getString(counter++),
                        resultSet.getString(counter++),
                        resultSet.getString(counter++),
                        resultSet.getString(counter++),
                        resultSet.getString(counter++),
                        resultSet.getString(counter++)
                        ));
            }
            Controller.setAddresses(tempAddress);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void purgeDatabase() {
        sendQuery("DROP DATABASE ".concat(databaseName).concat(";"));
        System.out.print("Database purged." +
                "\nUse external client to rebuild database before continuing to work on this program.\n");
    }

}
