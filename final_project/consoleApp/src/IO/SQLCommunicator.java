package IO;

import dataHandler.Controller;
import org.mariadb.jdbc.internal.util.exceptions.MariaDbSqlException;

import java.sql.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SQLCommunicator {

    // add ability to pull from SQL

    private static Connection connection;
    private static String databaseName = "final_project_store_database";

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
            if (connectionData.isEmpty()) {
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

    public static ResultSet getSQLItems(String entity) {
        entity = entity.toLowerCase();
        String SQLQuery;
        switch (entity) {
            case "customers": return sendQuery("SELECT * FROM CUSTOMER;");
            case "addresses": return sendQuery("SELECT * FROM ADDRESS;");
            case "invoices": return sendQuery("SELECT * FROM INVOICE;");
            case "articles": return sendQuery("SELECT * FROM ARTICLE;");
            default: System.out.print("Wrong.\n");
            return null;
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void updateSQLDatabase() {
        updateAddresses();

    }

    private static String parseDataAsString(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder("");
        sb.append("'").append(data).append("'");
        return sb.toString();
    }

    private static String sendAddress(dataClasses.Address address) {
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
            sendQuery(sendAddress(address));
        }
    }

    public static void updateLocalDataFromSQL() {
        return;
    }

    public static void purgeDatabase() {
        sendQuery("DROP DATABASE ".concat(databaseName).concat(";"));
        System.out.printf("Database purged. Use external client to rebuild database.\n");
        System.exit(0);
    }

}
