
package Classes;

import Interfaces.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author jumanah
 */
public class Database {

    static Connection connection = null;

    public static Connection getConnection() throws Exception, SQLException {
        //Load  JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Create connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CandyShop", "root", "");//Password
        return connection;
    }

    public static boolean checkLogin(String username, String password) throws Exception, SQLException {
        String username_DB = "", password_DB = "";
        //Create connection object
        connection = getConnection();
        //Create statment object
        Statement state = connection.createStatement();
        //Query to retrieve data from database
        ResultSet resultSet = state.executeQuery("SELECT Username,Password FROM customer WHERE Username =+'" + username + "'");

        while (resultSet.next()) {
            username_DB = resultSet.getString("Username");
            password_DB = String.valueOf(resultSet.getInt("Password"));
        }
        if (username_DB.equals(username) && password_DB.equals(password)) {
            return true;

        }

        return false;
    }

    public static void displayUserInfo(String username) throws Exception, SQLException {
        //Create connection object
        connection = getConnection();
        //Create statment object
        Statement state = connection.createStatement();
        //Query to iretrieve data from database
        ResultSet resultSet = state.executeQuery("SELECT * FROM customer WHERE Username =+'" + username + "'");
        //Display information
        while (resultSet.next()) {
            Profile.username.setText(resultSet.getString("Username"));
            Profile.name.setText(resultSet.getString("Name"));
            Profile.password.setText(resultSet.getString("Password"));
            Profile.phone.setText("0" + String.valueOf(resultSet.getInt("Phone_Number")));
        }
    }

    public static void updateUserInfo(String username) throws Exception, SQLException {
        //Create connection object
        connection = getConnection();
        //Query to update user data
        String query = "update customer set Password = ?, Name = ?, Phone_Number = ? WHERE Username = ?";
        //Create statment object
        PreparedStatement state = connection.prepareStatement(query);
        //Set the string value to the given index
        state.setString(1, Profile.password.getText());
        state.setString(2, Profile.name.getText());
        state.setInt(3, Integer.parseInt(Profile.phone.getText()));
        state.setString(4, Profile.username.getText());

        //Execute the prepared statement
        state.executeUpdate();
        //Display successfully message 
        JOptionPane.showMessageDialog(null, " The information has been sucessfully updated!");
        //close 
        state.close();
    }

    public static void displaySweetInfo(String firstID, String secondID) throws Exception, SQLException {
        //Create connection object
        connection = getConnection();
        //Create statment object
        Statement state = connection.createStatement();
        ResultSet resultSet;

        if (firstID == "DarkC" || firstID == "SourG") {
            //Query to retrieve data from database
            resultSet = state.executeQuery("SELECT * FROM sweet WHERE ID =+'" + firstID + "'");
            //Display information
            while (resultSet.next()) {
                //Candy 1
                Shop.candy1.setText(resultSet.getString("Name"));
                Shop.flavor1.setText(resultSet.getString("Flavor"));
                Shop.price1.setText(String.valueOf(resultSet.getInt("Price")));
            }
        }
        if (secondID == "WhiteC" || secondID == "BearG") {
            //Query to retrieve data from database
            resultSet = state.executeQuery("SELECT * FROM sweet WHERE ID =+'" + secondID + "'");
            //Display information
            while (resultSet.next()) {
                //Candy 2
                Shop.candy2.setText(resultSet.getString("Name"));
                Shop.flavor2.setText(resultSet.getString("Flavor"));
                Shop.price2.setText(String.valueOf(resultSet.getInt("Price")));
            }
        }
    }

    public static void displayOrderInfo(String username, String password) throws Exception, SQLException {
        String ordernum="",type="",flavor="",quantity="",price="";
        if (checkLogin(username, password) == true) {
            //Create connection object
            connection = getConnection();
            //Create statment object
            Statement state = connection.createStatement();
            //Query to iretrieve data from database
            ResultSet resultSet = state.executeQuery("SELECT * FROM customerOrders WHERE Username =+'" + username + "'");
            //Display information
            while (resultSet.next()) {
              ordernum= resultSet.getString("OrderNumber");
                type=resultSet.getString("Type");
               flavor=resultSet.getString("Flavor");
                quantity=resultSet.getInt("Quantity")+"";
               price=resultSet.getDouble("Price")+"";
            }
             Order.oNum.setText(ordernum);
                Order.type.setText(type);
                Order.falovr.setText(flavor);
                Order.quantity.setText(quantity);
                Order.price.setText(price);
        }
    }

}
