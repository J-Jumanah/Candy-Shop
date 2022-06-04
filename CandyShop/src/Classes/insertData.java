
package Classes;

import static Classes.Database.*;
import static Classes.Database.getConnection;
import Interfaces.Order;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jumanah
 */
public class insertData {


    public static void main(String[] args) throws Exception, SQLException {

         insertCustomer();
         insertSweet();
    }

    static public void insertCustomer() throws Exception, SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();

        st.executeUpdate("INSERT INTO customer" + " VALUES( 'jj1', '1234','Jumanah Jan' , 0505123457)");
        st.executeUpdate("INSERT INTO customer" + " VALUES( 'fd1', '12345','Fay Manee' , 0505123456)");
        st.executeUpdate("INSERT INTO customer" + " VALUES( 'js1', '123456','Jamela Saad' , 0505123458)");

        System.out.println("Data inserted");

        con.close();
    }

    static public void insertSweet() throws Exception, SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();
//        String path = "~/CandyImages/Pomegranate.jpg";
        //Chocolate
        st.executeUpdate("INSERT INTO sweet" + " VALUES( 'DarkC', 'Dark Chocolate','Chocolate' ,'Pomegranate' , 80)");
        st.executeUpdate("INSERT INTO sweet" + " VALUES( 'WhiteC', 'White Chocolate','Chocolate' ,'Oreo' , 75)");
        //Gummy bear
        st.executeUpdate("INSERT INTO sweet" + " VALUES( 'SourG', 'Sour Gummy','Gummy Candy' ,'12 Flavors' , 36)");
        st.executeUpdate("INSERT INTO sweet" + " VALUES( 'BearG', 'Gummy Bear','Gummy Candy' ,'12 Flavors' , 34)");

        System.out.println("Data inserted");

        con.close();
    }

    static public void saveOrders(String username, String candyType, String candyFlavor, int quantity, double price) throws Exception, SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();

        String orderNumber = CandyShop.generateOrderID();
        st.executeUpdate("INSERT INTO customerOrders" + " VALUES('" + username + "','" + candyType + "','" + candyFlavor + "','" + quantity + "','" + price + "','" + orderNumber + "')");
        System.out.println("1: " + username + " 2: " + candyType + " 3: " + candyFlavor + " 4: " + price + " 5:" + orderNumber);

        System.out.println("Data inserted");

        con.close();
    }

    public static void addNewUser(String username, String password, String Name, int PhoneNumber) throws Exception, SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();

        st.executeUpdate("INSERT INTO customer" + " VALUES('" + username + "','" + password + "','" + Name + "','" + PhoneNumber + "')");

        System.out.println("Data inserted");

        con.close();
    }

    public static void customize(String ID, String Type, String Color, String Flavor, String Text, String Logo, int Quantity, double Price) throws Exception, SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();

        st.executeUpdate("INSERT INTO customizesweet" + " VALUES('" + ID + "','" + Type + "','" + Color + "','" + Flavor + "','" + Text + "','" + Logo + "','" + Quantity + "','" + Price + "')");

        System.out.println("Data inserted");

        con.close();
    }

    public static String readData(String ID) throws Exception {
        String type = "";
        connection = getConnection();
        //Create statment object
        Statement state = connection.createStatement();
        //Query to iretrieve data from database
        ResultSet resultSet = state.executeQuery("SELECT Type FROM customizesweet WHERE ID=+'" + ID + "'");
        //Display information
        while (resultSet.next()) {
            type = resultSet.getString("Type");

        }

        connection.close();
        return type;

    }

    public static void storeForm(String name, String city, String phone, String subject, String msg) throws Exception, SQLException {
        Connection con = Database.getConnection();
        Statement st = con.createStatement();

        st.executeUpdate("INSERT INTO customerForms" + " VALUES('" + name + "','" + city + "','" + phone + "','" + subject + "','" + msg + "')");

        System.out.println("Data inserted");

        con.close();
    }

    public static Boolean readForms(String phone, String sub) throws Exception {
        String subject = "";
        connection = getConnection();
        //Create statment object
        Statement state = connection.createStatement();
        //Query to iretrieve data from database
        ResultSet resultSet = state.executeQuery("SELECT subject FROM customerForms WHERE phone=+'" + phone + "'");
        //Display information
        while (resultSet.next()) {
            subject = resultSet.getString("subject");

        }

        connection.close();

        if (subject.equalsIgnoreCase(sub)) {
            return true;
        }

        return false;
    }

}
