
import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe {
    public static void main(String[] args) {
        CafeUtil safeBusiness = new CafeUtil();

        // Streack Goal Test
        
        System.out.println("\n---- Streack Goal Test ----"); 
        System.out.printf("purshases needed by week 10: %s  \n\n",safeBusiness.getStreakGoal());

        // Order Total Test

        System.out.println("\n--- Order Total Test ----");
        double[] lineItems = {3.5,1.5,4.0,4.5};
        System.out.printf("order Total: %s \n\n",safeBusiness.getOrderTotal(lineItems));


        // Display Menu Item

        System.out.println("\n -----Display Menu Item -----");
        ArrayList <String> Menu = new ArrayList<String>();
        Menu.add("drip coffe");
        Menu.add("cappuccino");
        Menu.add("latte");
        Menu.add("mocha");
        safeBusiness.displayMenu(Menu);

        // Add Customer Test
        // System.out.println("\n ----- Add Customer Test -----");
        // ArrayList <String> Customers = new ArrayList<String>();
        // safeBusiness.addCustomer(Customers);

        //  Print Price Chart
        System.out.println("\n ----- Print Price chart -----");
        safeBusiness.printPriceChart("Columbian Coffee Grounds", 15, 03);

        // Print Price with discount
        System.out.println("\n ----- Print Price with discount ----");
        safeBusiness.printPriceChartDiscount("Columbian Coffee Grounds", 2, 0.5, 4);

        // --------------****************** Bonus: Print Menu Product & Prices------------------
        System.out.print("\n********* Print Menu Product & Prices ************");
        safeBusiness.displayMenu(Menu, lineItems);

        // --------------****************** Bonus: Add Customers------------------
        System.out.print("\n********* Bonus: Add Customers ************");
        ArrayList <String> customers = new ArrayList<String>();
        safeBusiness.addCustomers(customers);
    }

    
    
}
