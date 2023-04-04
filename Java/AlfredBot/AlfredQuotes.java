import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        
        String guestGreetingMsg = String.format("Hello, %s ,lovely to see you. How are you?", name);

        return guestGreetingMsg;
    }
    
    public String dateAnnouncement() {
        Date getDate = new Date();
        return "Current date is: " + getDate ;
    }
    
    public String respondBeforeAlexis(String conversation) {
        // YOUR CODE HERE
        
        int a = conversation.indexOf("Alexis");
        int b = conversation.indexOf("Alfred");
        String responseMsg;

        if (a>=0){
            responseMsg = "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        else if (b>=0){
            responseMsg = "At your service. As you wish, naturally.";
        }
        else {
            responseMsg = "Right. And with that I shall retire." ;
        }
        return responseMsg;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}


