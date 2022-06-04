
package Classes;

import java.sql.*;

/**
 *
 * @author jumanah
 */
public class creatDataBase {

    public static void main(String[] args) throws Exception, SQLException {


        Connection con = null;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // (2) set the path for the database
        String ConnectionURL = "jdbc:mysql://localhost:3306";
           
        // (3) create connection
        con = DriverManager.getConnection(ConnectionURL,"root","") ;//Password

        Statement st = con.createStatement();

        String database = "CandyShop";

        st.executeUpdate("CREATE SCHEMA " + database);

        System.out.println("Database is created");

        con.close();

    }
}
