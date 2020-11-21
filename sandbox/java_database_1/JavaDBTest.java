/* connect to a database
 * insert dummy values from a list
 */

import java.sql.*; // we need this to connect to the db

public class JavaDBTest {
   public static void main(String[] args)
      throws SQLException, ClassNotFoundException { // what does this do?
      Class.forName("com.mysql.jdbc.Driver");
      System.out.print("Driver loaded\n");

      // getConnection(dblocation, u, p)
      Connection connect = DriverManager.getConnection(
         "jdbc:mysql://localhost/edunova", "edunova", "edunova");

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
