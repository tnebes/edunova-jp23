package IO.SQL;

import IO.DataIO;

import java.sql.*;
import java.util.StringTokenizer;

public class SQLCommunicator {

    // add ability to pull from SQL

    private static Connection connection;
    private static final String databaseName = "final_project_store_database";
    static final int CUSTOMERS = 0;
    static final int ADDRESSES = 1;
    static final int INVOICES = 2;
    static final int ARTICLES = 3;
    static final int STATUSES = 4;
    static final int TRANSACTION_TYPES = 5;

    /**
     * Connects to the database.
     */
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

    /**
     * Creates a connection to the database. If no connection data is found in external file,
     * show error and exit. If the connection cannot be established, exit.
     *
     * @return connection to database.
     */
    private static Connection createConnection() {
        Connection myConnection = null;
        String connectionData;
        try {
            connectionData = DataIO.getSQLConnectionData();
            if (connectionData.isBlank()) {
                System.out.print("SQL connection data is blank.\n" +
                        "Connection data should be written to MYSQL.txt as\n" +
                        "URL username password\n" +
                        "Exiting...\n");
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

    /**
     * Sends a query to the database.
     * @param query
     * @return ResultSet
     */
    static ResultSet sendQuery(String query) {
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

    /**
     * Helper method for returning certain data from the database.
     * @param entity
     * @return ResultSet
     */
    public static ResultSet getSQLItems(int entity) {
        switch (entity) {
            case CUSTOMERS:         return sendQuery("SELECT * FROM customer;");
            case ADDRESSES:         return sendQuery("SELECT * FROM address;");
            case INVOICES:          return sendQuery("SELECT * FROM invoice;");
            case ARTICLES:          return sendQuery("SELECT * FROM article;");
            case STATUSES:          return sendQuery("SELECT * FROM status;");
            case TRANSACTION_TYPES: return sendQuery("SELECT * FROM transaction_type;");
            default: System.out.print("Wrong.\n");
            return null;
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void updateSQLDatabase() {
        GetterSetter.updateAddresses();
        // TODO article_invoice
        GetterSetter.updateArticles();
        GetterSetter.updateInvoices();
        // TODO customer
        GetterSetter.updateStatuses();
        GetterSetter.updateTransactionTypes();


    }

    /**
     * Helper method that parses a string as a SQL-valid input
     * @param data
     * @return SQL-valid input
     */
    static String parseDataAsString(String data) {
        if (data == null || data.isBlank()) {
            return null;
        }
        return "" + "'" + data + "'";
    }

    /**
     * Retrieves all data from SQL database. Updates counters when necessary.
     */
    public static void updateLocalDataFromDB() {
        // TODO article_invoice
        GetterSetter.getAddressesFromDB();
        GetterSetter.getInvoicesFromDB();
        // TODO GetterSetter.getCustomersFromDB();
        GetterSetter.getStatusesFromDB();
        GetterSetter.getTransactionTypesFromDB();
        GetterSetter.getArticlesFromDB();
        // TODO associate data with other data (invoices to customers, etc.)
        DataIO.writeDataToFiles();
    }

    public static void purgeDatabase() {
        sendQuery("DROP DATABASE ".concat(databaseName).concat(";"));
        System.out.print("Database purged." +
                "\nUse external client to rebuild database before continuing to work on this program.\n");
    }

}
