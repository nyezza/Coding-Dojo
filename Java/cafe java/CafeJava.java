public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        // Lines of text that will appear in the app. 
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffeePrice = 1.5;
        double lattePrice = 4;
        double cappucinnoPrice = 4.5;

        // Customer name variables (add yours below)
        String customer1 = "Cindhuri";
        String custSam = "Sam";
        String custJimmy = "Jimmy";
        String custNoah = "Noah";

    
        // Order completions (add yours below)
        boolean isReadyOrder1 = false;
        boolean samOrder = false;
        boolean jimmyOrder =  false;
        boolean noahOrder = false;
    
        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    	// ** Your customer interaction print statements will go here ** //

        // Cindhuri order
        System.out.println(isReadyOrder1 ?  pendingMessage : readyMessage);

        // Noah Order
        if (noahOrder){
            System.out.println(custNoah + readyMessage +" "+ displayTotalMessage  + cappucinnoPrice);
        }
        else {
            System.out.println(custNoah + pendingMessage);
        }

        // Sam Order
        int qtelatte=2;
        if (samOrder){
            double totalOrder = (lattePrice * qtelatte);
            System.out.println(custSam+ readyMessage +" "+ displayTotalMessage + totalOrder);
        }
        else {
            System.out.println(custSam + pendingMessage);
        }

        // Jimmy Order
            double jimOrderPrice = lattePrice - dripCoffeePrice;
            if (jimmyOrder){
                System.out.println(custJimmy+ readyMessage +" "+ displayTotalMessage + jimOrderPrice);
            }
            else {
                System.out.println(custJimmy + pendingMessage);
            }
    }
}
