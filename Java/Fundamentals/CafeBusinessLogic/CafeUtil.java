import java.util.ArrayList;
import java.util.Arrays;
public class CafeUtil {
    
    public int getStreakGoal(){
        int numWeeks=10;
        int sum=0;
        //int i;
        for (int i=0; i<=numWeeks; i++){
            sum = sum+i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double totalPrices = 0;
        for (int i=0; i<= prices.length-1;i++){
            totalPrices = totalPrices + prices[i];
        }
        return totalPrices;
    }

    void displayMenu(ArrayList<String> menuItems){
        for (int i=0; i<= menuItems.size()-1; i++){
            System.out.println(i+" : "+menuItems.get(i));
        }
    }

    void displayMenu(ArrayList<String> menuItems, double[] prices){
        if (menuItems.size() != prices.length){
            System.out.println("the are an errors,  the arrays are not the same size ");
        }
        else{
            for (int i=0; i<= menuItems.size()-1; i++){
            //System.out.println(i+" : "+menuItems.get(i));
            System.out.printf("%d  %s  ---  $%.2f \n", i, menuItems.get(i),prices[i]);
            }
        }
    }

    void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        
        customers.add(userName);
        System.out.printf("There are %d people in front of you",customers.size());
        for(int i=0; i<= customers.size()-1;i++){
            System.out.printf("\n Hello %s !",userName);
        }
    }

    void printPriceChart(String product, double price, int maxQuantity){
        System.out.println(product);
        for (int i=1; i<=maxQuantity;i++){
            System.out.printf(" %d- $%.2f \n",i,price*i);
        }
    }

    void printPriceChartDiscount(String product, double price,double discount ,int maxQuantity){
        System.out.printf("the product is : %s with $%.2f discount\n",product,discount);
        for (int i=1; i<=maxQuantity;i++){
            
            System.out.printf("%d- %.2f\n ",i,(price*i)-((i-1)*discount));
        }
    }

    void addCustomers(ArrayList<String> customers){
        String user= customers.get(customers.size()-1);
        while (user != "q"){
            System.out.println("Please enter your name:");
            user = System.console().readLine();
            customers.add(user);
        }
    }
}