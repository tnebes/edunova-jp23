/* connect to a database
 * insert dummy values from a list
 */
package JDBC; // do I need this???

import java.sql.*; // we need this to connect to the db

public class JavaDBTest {
   public static void main(String[] args)
      throws SQLException, ClassNotFoundException { // what does this do?
      try {
         Class.forName("com.mysql.jdbc.Driver");
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
      System.out.print("Driver loaded\n");

      // setting up the connection
      final String URL = "jdbc:mysql://localhost/";
      final String DATABASE_NAME = "java_db_test";
      final String USERNAME = "edunova";
      final String PASSWORD = "edunova";

      //connecting to localhost to prepare the database
      Connection connection = DriverManager.getConnection(
         URL, USERNAME, PASSWORD);
      prepareDatabase(connection, DATABASE_NAME);

      //connecting to the prepared database
      connection = DriverManager.getConnection(
         URL + DATABASE_NAME, USERNAME, PASSWORD);

      //dummy data for the database
      String[] names = new String[] {"Tomislav", "Lucija", "Petar",
         "Dragan", "Zeljko", "Bobo"};
      String[] bands = new String[] {"Svemirko", "Pocket Palma", "Haustor",
         "Trevor Something", "Led Zeppelin", "Vuco"};

      // creating SQL entities
      // this is suboptimal lmao
      String[] entities = new String[] {"person", "band", "person_band"};
      Statement statement;
      for (int i = 0; i < entities.length - 1; i++) {
         statement = connection.createStatement();
         String sql_statement = "create table " + entities[i] + "(id integer primary key not null auto_increment, "
               + " name varchar(25) not null)";
         statement.executeUpdate(sql_statement);
      }

      statement = connection.createStatement();
      statement.executeUpdate("create table " + entities[entities.length - 1] +
         "(person integer not null, " +
         " band integer not null)");
      statement.executeUpdate("alter table " + entities[entities.length - 1] +
            " add foreign key (band) references band(id)");
      statement.executeUpdate("alter table " + entities[entities.length - 1] +
            " add foreign key (person) references person(id)");


      writeUsers(connection, names);
      writeBands(connection, bands);
      userListensBand(connection, names, bands);
   }

   /** creates or resets a database so that the test can proceed
    * nominally each time.
    */
   public static void prepareDatabase(Connection connection,
      String database_name) throws SQLException, ClassNotFoundException {
      Statement statement = connection.createStatement();
      statement.executeUpdate("drop database if exists java_db_test");
      statement.executeUpdate("create database java_db_test");
   }

   /** Writes given records to a table. NOTE: When entering data
    * into an SQL table, DON'T FORGET TO USE SINGLE QUOTES!!!
    * note(tnebes) this a terrible way to insert records.
    */
   public static void insertIntoTable(
      Connection connection, String table_name,
      String parameters, String data)
      throws SQLException, ClassNotFoundException {
         Statement statement = connection.createStatement();
         String sql_statement = "insert into " + table_name +
            "(" + parameters + ") " +
            "values (" + data + ")";
         statement.executeUpdate(sql_statement);
   }

   /** Writes users to database 
    */
   public static void writeUsers(Connection connection, String[] names)
      throws SQLException, ClassNotFoundException {
      for (String name : names) {
         insertIntoTable(connection, "person", "name", "'" + name + "'");
      }
   }

   /** Writes bands to database
    */
   public static void writeBands(Connection connection, String[] bands)
      throws SQLException, ClassNotFoundException {
      for (String band : bands) {
         insertIntoTable(connection, "band", "name",  "'" + band + "'");
      }
   }

   /** Establishes relationship between the listeners and
    * the database
    */
   public static void userListensBand(Connection connection,
      String[] names, String[] bands)
      throws SQLException, ClassNotFoundException {
      // randomly create records
      java.util.Random rng = new java.util.Random();
      int number_of_records = rng.nextInt(25);
      for (int i = number_of_records; i > 0; i--) {
         String data;
         data = (1 + rng.nextInt(names.length)) + ", " +
            (1 + rng.nextInt(bands.length));
         insertIntoTable(connection, "person_band", "person, band", data);
      }
   }

}
