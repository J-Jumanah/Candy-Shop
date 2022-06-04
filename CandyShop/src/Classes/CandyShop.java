
package Classes;

import java.text.DecimalFormat;

/**
 *
 * @author jumanah
 */
public class CandyShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static double calculatePrice(double price, int quantity) {
        DecimalFormat df = new DecimalFormat("0.00");
        double Vat = 0.15 * price;
        double priceVat = Vat + price;
        double totalPrice = priceVat * quantity;
        double doubleTotal = Double.valueOf(df.format(totalPrice));
        return doubleTotal;
    }

    public static String generateOrderID() {
        String trim = "10";
        int number = (int) (Math.random() * 100);
        String orderNum = trim + number;
        return orderNum;
    }
    
     public static String generateshipID() {
        String trim = "10";
        int number = (int) (Math.random() * 10000);
        String orderNum = trim + number;
        return orderNum;
    }

}
