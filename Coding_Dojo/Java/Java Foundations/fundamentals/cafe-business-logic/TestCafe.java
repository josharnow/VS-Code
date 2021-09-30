import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestCafe {
    
  public static void main(String[] args) {
    CafeUtil appTest = new CafeUtil();

    // getStreakGoal()
    System.out.println("----- Streak Goal Test -----");
    System.out.printf("Purchases needed by week 10: %d \n", appTest.getStreakGoal());
    System.out.printf("Purchases needed by week %d: %d \n", 9, appTest.getStreakGoal(9));

    // printPriceChart(String, double, int)
    System.out.println("----- Price Chart Test-----");
    appTest.printPriceChart("Chai Latte Mix", 4.5, 3);
    appTest.printPriceChart("Specialty Coaster", 2.0, 5);

    // getOrderTotal(double[])
    System.out.println("----- Order Total Test-----");
    double[] lineItems = { 3.5, 1.5, 4.0, 4.5 };
    System.out.printf("Order total: $%.2f \n", appTest.getOrderTotal(lineItems));

    // displayMenu(ArrayList<String>, ArrayList<Double>)
    System.out.println("----- Display Menu Test-----");
    List<String> loadMenu = Arrays.asList("drip coffee", "cappucino", "latte", "mocha");
    List<Double> loadPrices = Arrays.asList(1.5, 3.5, 4.5, 3.5);
    ArrayList<String> menu = new ArrayList<String>();
    ArrayList<Double> prices = new ArrayList<Double>();
    // Note: Below is a way to add multiple elements to a list in fewer lines.
    // It does require an extra import at the top of the file.
    menu.addAll(loadMenu);
    prices.addAll(loadPrices);
    appTest.displayMenu(menu, prices);

    // addCustomer(ArrayList<String>)
    System.out.println("----- Add Customer Test-----");
    ArrayList<String> customers = new ArrayList<String>();
    // Test 4 times
    for (int i = 0; i < 4; i++) { 
      appTest.addCustomer(customers); 
      System.out.println(customers);
    }

    // Sensei Bonus:
    // Make a method addCustomers where a barista can enter multiple customers.
    // Hint: You can use a while loop and ask the user to type "q" when they are
    // finished entering names.

    // addCustomers(ArrayList<String>)
    System.out.println("----- Add Customers Test-----");
    ArrayList<String> senseiCustomers = new ArrayList<String>();
    appTest.addCustomers(senseiCustomers);
    System.out.println(senseiCustomers);
    // while (senseiCustomers.indexOf("q") == -1) {
    // }
  }
}