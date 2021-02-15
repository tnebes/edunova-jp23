package IO;

import org.mariadb.jdbc.internal.util.exceptions.MariaDbSqlException;

import java.sql.*;
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
        ResultSet resultSet;
        try {
            Statement myStatement = connection.createStatement();
            resultSet = myStatement.executeQuery(query);
            return resultSet;
        } catch (SQLTransientConnectionException e) {
            e.printStackTrace();
            return null;
        } catch (MariaDbSqlException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            connection = createConnection();
            return sendQuery(query);
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

    }

    public static void updateLocalDataFromSQL() {

    }

    public static void purgeDatabase() {
        sendQuery("DROP DATABASE ".concat(databaseName).concat(";"));
        sendQuery("CREATE DATABASE ".concat(databaseName.concat(" ").concat("CHARACTER SET utf8;")));
        System.out.printf("Database purged. Populate using SQL script.\n");
    }
}
