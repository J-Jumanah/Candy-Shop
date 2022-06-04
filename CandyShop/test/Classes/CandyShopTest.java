/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author apple
 */
public class CandyShopTest {
   /**
     * Test of calculatePrice method, of class CandyShop.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        double price = 20;
        int quantity = 1;
        double expResult = 23.0;
        double result = CandyShop.calculatePrice(price, quantity);
        assertTrue(expResult == result);
     
    }
    
}
