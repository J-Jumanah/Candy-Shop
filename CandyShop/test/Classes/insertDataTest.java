/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apple
 */
public class insertDataTest {

    /**
     * Test of customize method, of class insertData.
     */
    
    
    @Test
    public void testCustomize() throws Exception {
        System.out.println("customize");
        String ID = "19";
        String Type = "Gummy Candy";
        String Color = "White";
        String Flavor = "Cherry";
        String Text = "test2";
        String Logo = null;
        int Quantity = 1;
        double Price = 30;
        insertData.customize(ID, Type, Color, Flavor, Text, Logo, Quantity, Price);
        
         Assert.assertEquals(Type, insertData.readData(ID));
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of storeForm method, of class insertData.
     */
    @Test
    public void testStoreForm() throws Exception {
        System.out.println("storeForm");
        String name = "Moon";
        String city = "Jeddah";
        String phone = "0987654326";
        String subject = "Call me.";
        String msg = "Add new features pls.";
       insertData.storeForm(name, city, phone, subject, msg);
       Boolean check= insertData.readForms(phone,subject);
        assertTrue(check);
    }
    
}
