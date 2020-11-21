/* connect to a database
 * insert dummy values from a list
 */
package JDBC;

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

      String url = "jdbc:mysql://localhost/edunova";
      String username = "edunova";
      String password = "edunova";

      Connection connect = DriverManager.getConnection(
         url, username, password);

      String[] names = new String[] {"Tomislav", "Lucija", "Petar",
         "Dragan", "Zeljko", "Bobo"};
      String[] bands = new String[] {"Svemirko", "Pocket Palma", "Haustor",
         "Trevor Something", "Led Zeppelin", "Vuco"};

      writeUsers(names);
      writeBands(bands);
      userListensBand(names, bands);
   }

   public static void writeToDatabase() {
   
   }

   public static void writeUsers(String[] names) {
   
   }

   public static void writeBands(String[] bands) {
   
   }

   public static void userListensBand(String[] names, String[] bands) {
   
   }
}
