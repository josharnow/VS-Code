import java.util.ArrayList;
import java.util.Iterator;

public class CafeUtil {
  /**
 * Starting with 1, sums together all the numbers from 1 to 10. This will calculate how many drinks a customer needs to buy.
 * @return The sum after it has been calculated [short]
 */
  public short getStreakGoal() {
    short weeklyDrinks = 0;
    short sum = 0;
    for (byte week = 1; week <= 10; ++week) {
      ++weeklyDrinks;
      sum += weeklyDrinks;
    }

    return sum;
  }

  public short getStreakGoal(int numWeeks) {
    short weeklyDrinks = 0;
    short sum = 0;
    for (byte week = 1; week <= numWeeks; ++week) {
      ++weeklyDrinks;
      sum += weeklyDrinks;
    }

    return sum;
  }


  /**
 * Given a productName, price and a maxNumber per customer, print the cost for buying different quantities up to the given number.
 * @param productName Product name [String]
 * @param price Price [double]
 * @param maxNumber Max number per customer [int]
 */
  public void printPriceChart(String productName, double price, int maxNumber) {
    System.out.println(productName);
    for (byte number = 1; number <= maxNumber; ++number) {
      double totalPrice = number * price;

      if (number > 1) {
        totalPrice -= .5 * (number - 1);
      }

      System.out.println(String.format("%d - $%.2f", number, totalPrice));
    }
  }

  /**
   * Given an array of the prices from the items in a customer order, iterate over the array to sum each item price and to return the total.
   * @param orderItemPrices Prices from the items in a customer order [array - doubles]
   * @return The sum for all the numbers in the given array [double]
   */
  public double getOrderTotal(double[] orderItemPrices) {
    double sum = 0;
    for (double singleItemPrice : orderItemPrices) {
      sum += singleItemPrice;
    }

    return sum;
  }

  /**
 * Given an ArrayList of menu item names (strings), and a price index ArrayList, iterate through the menuItems array and print the item id (index), the menu item name, as well as the corresponding price from the priceIndex array.
 * @param itemList List of menu item names [ArrayList - Strings]
 * @param itemPrice List of menu item prices [ArrayList - Doubles]
 */
  public void displayMenu(ArrayList<String> itemList, ArrayList<Double> itemPrice) {

    Iterator<String> itemListIterator = itemList.iterator();
    Iterator<Double> itemPriceIterator = itemPrice.iterator();

    byte i = 0;
    while (itemListIterator.hasNext()) {
      System.out.printf("%d %s -- $%.2f \n", i, itemListIterator.next(), itemPriceIterator.next());
      ++i;
    }
  }

  /**
 * Given a list of existing customer names (strings), prints a string to the console asking the user for their name. Next, prints the userName to the console, saying "Hello, [user name here]!" and prints the number for how many people are ahead of them. Then, adds the customer's name to the given customers list.
 * @param customerList List of existing customers [ArrayList - Strings]
 */
  public void addCustomer(ArrayList<String> customerList) {
    System.out.println("Please enter your name:");
    String userName = System.console().readLine();

    System.out.printf("Hello, %s! \n", userName);
    System.out.printf("There are %d people ahead of you ", customerList.size());

    customerList.add(userName);
  }

  /**
   * Given a list of existing customer names (strings), prints a string to the console asking the user to input multiple names, one per line. Then, adds all the customer names to the given customers list.
   * @param customerList List of existing customers [ArrayList - Strings]
   */
  public void addCustomers(ArrayList<String> customerList) {
    
    System.out.println("Please enter each customer name. Click return on your keyboard to move to the next customer for entry; type \"q\" and return to complete entries.");
    
    while (customerList.indexOf("q") == -1) {
      customerList.add(System.console().readLine());
    }
    
    int customerListLastIndex = customerList.size() - 1;
    // System.out.println(customerListLastIndex);
    customerList.remove(customerListLastIndex);

    // String userName;
    // userName = System.console().readLine();

    // while (customerList.indexOf("q") == -1) {
    //   if (userName == "q") {
    //     break;
    //   }
    //   customerList.add(userName);
    // }
    
    // while (System.console().readLine().equals("q") == false) {
    //   customerList.add(System.console().readLine());
    // }

    // while (userName != "q") {
    //   customerList.add(userName);
    //   ++i;
    // }
  }
}
