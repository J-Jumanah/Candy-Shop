
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jumanah
 */
public class createTable {

    public static void main(String[] args) throws Exception, SQLException {

          customerTable();
          sweetTable();
          customizeSweetTable();
          customerOrders();
          customerForms();

    }

    static public void customerTable() throws Exception, SQLException {
        Connection con = Database.getConnection();

        Statement st = con.createStatement();

        String sql = "CREATE TABLE customer "
                + "(Username VARCHAR(20) not null, "
                + "Password VARCHAR(15) not null,"
                + "Name VARCHAR(20),"
                + "Phone_Number INTEGER,"
                + "PRIMARY KEY ( Username))";

        st.executeUpdate(sql);
        System.out.println("Table is created");

        con.close();
    }

    static public void sweetTable() throws Exception, SQLException {
        Connection con = Database.getConnection();

        Statement st = con.createStatement();

        String sql = "CREATE TABLE sweet "
                + "(ID VARCHAR(10) not null, "
                + "Name VARCHAR(15) not null,"
                + "Type VARCHAR(15),"
                + "Flavor VARCHAR(15),"
                + "Price INTEGER,"
                + "PRIMARY KEY ( ID))";

        st.executeUpdate(sql);
        System.out.println("Table is created");

        con.close();
    }

    static public void customizeSweetTable() throws Exception, SQLException {
        Connection con = Database.getConnection();

        Statement st = con.createStatement();

       
       String sql = "CREATE TABLE customizeSweet "
                + "(ID VARCHAR(10) not null, "
                + "Type VARCHAR(20),"
                + "Color VARCHAR(20),"
                + "Flavor VARCHAR(20),"
                + "Text VARCHAR(20),"
                + "Logo blob,"
                + "Quantity INTEGER,"
                + "Price INTEGER,"
                + "PRIMARY KEY ( ID))";


        st.executeUpdate(sql);
        System.out.println("Table is created");

        con.close();
    }

    static public void customerOrders() throws Exception, SQLException {
        Connection con = Database.getConnection();

        Statement st = con.createStatement();

        String sql = "CREATE TABLE customerOrders "
                + "(Username VARCHAR(10) not null, "
                + "Type VARCHAR(20),"
                + "Flavor VARCHAR(20),"
                + "Quantity INTEGER,"
                + "Price DOUBLE,"
                + "OrderNumber INTEGER)";

        st.executeUpdate(sql);
        System.out.println("Table is created");

        con.close();
    }
        static public void customerForms() throws Exception, SQLException {
        Connection con = Database.getConnection();

        Statement st = con.createStatement();

        String sql = "CREATE TABLE customerForms "
                + "(fullname VARCHAR(30) not null, "
                + "city VARCHAR(20),"
                + "phone VARCHAR(10),"
                + "subject VARCHAR(20),"
                + "msg VARCHAR(100))";

        st.executeUpdate(sql);
        System.out.println("Table is created");

        con.close();
    }
}
