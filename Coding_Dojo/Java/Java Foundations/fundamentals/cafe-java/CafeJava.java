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
    double dripCoffeePrice = 3.0;
    double lattePrice = 3.25;
    double cappuccinoPrice = 4.0;

    // Customer name variables (add yours below)
    String customer1 = "Cindhuri";
    String customer2 = "Sam";
    String customer3 = "Jimmy";
    String customer4 = "Noah";

    // Order completions (add yours below)
    boolean isReadyOrder1 = false;
    boolean isReadyOrder2 = false;
    boolean isReadyOrder3 = false;
    boolean isReadyOrder4 = false;

    // APP INTERACTION SIMULATION (Add your code for the challenges below)
    double total;

    total = dripCoffeePrice;
    System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"
    if (isReadyOrder1) {
      System.out.println(customer1 + readyMessage);
      System.out.println(displayTotalMessage + String.format("%.2f", total));
    } else {
      System.out.println(customer1 + pendingMessage);
    }

    total = cappuccinoPrice;
    System.out.println(generalGreeting + customer4); // Displays "Welcome to Cafe Java, Cindhuri"
    isReadyOrder4 = true;
    if (isReadyOrder4) {
      System.out.println(customer4 + readyMessage);
      System.out.println(displayTotalMessage + String.format("%.2f", total));
    } else {
      System.out.println(customer4 + pendingMessage);
    }

    total = lattePrice * 2;
    System.out.println(generalGreeting + customer2);
    System.out.println(displayTotalMessage + String.format("%.2f", total));
    isReadyOrder2 = true;
    if (isReadyOrder2) {
      System.out.println(customer2 + readyMessage);
    } else {
      System.out.println(customer2 + pendingMessage);
    }

    total = lattePrice - dripCoffeePrice;
    System.out.println(displayTotalMessage + total);
  }
}

// Cindhuri ordered a coffee. Print to the console the correct status message, based on her order status.

// Noah ordered a cappuccino. Use an if statement to check the status of his order and print the correct status message. If it is ready, also print the message to display the total. Note: Outcomes may be different depending on what you assigned as the status.

// Sam just ordered 2 lattes, print the message to display their total first. Next print the appropriate order status message. Change the isReady flag value from true to false or vice versa in order to test your
// control logic (if-statements).

// Jimmy just realized he was charged for a coffee but had ordered a latte. Tell him his new total (what he owes) to make up the difference.

// Try changing the price values for each drink and isReady flags (booleans), to test if all of your logic works, even when prices and statuses are changed.