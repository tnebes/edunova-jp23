package IO;

import java.sql.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SQLCommunicator {

    // add ability to pull from SQL

    private static Connection connection;

    public static void initialise() {
        connection = createConnection();
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
            System.out.printf("Successfully connected to SQL database %s %s.\n",
                    myConnection.getMetaData().getDatabaseProductName(),
                    myConnection.getMetaData().getDatabaseMajorVersion());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return myConnection;
    }

    public static PreparedStatement getQueryResults(String query) {
        PreparedStatement queryResults = sendQuery(query);
        return null;
    }

    private static PreparedStatement sendQuery(String query) {
        return null;
    }

    public static Connection getConnection() {
        return connection;
    }

}
