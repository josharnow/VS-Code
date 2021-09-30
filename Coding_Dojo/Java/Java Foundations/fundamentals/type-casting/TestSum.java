public class TestSum {
//   public static void main(String[] args) {
//     long start = System.currentTimeMillis();
//     Integer sum = 0;
//     for (int i = 0; i < Integer.MAX_VALUE; i++) {
//         sum += i;
//     }
//     System.out.println("Sum: " + sum);
//     long end = System.currentTimeMillis();
//     double total = (double) (end - start) / 1000;
//     System.out.println("Time of execution: " + total + " seconds");
// }

/**
 * SUPERIOR METHOD
 * 
 * Reason:
 * "Now, that's a lot of seconds just to get the sum of integers. Why is it taking so long? Well, we naively set the sum variable to Integer type. Therefore, in our for-loop, every time we add i to sum, we are actually creating an instance of Integer with the value of i. Totally unnecessary. All we have to do is declare sum to be an int from the beginning."
 * @param args
 */
public static void main(String[] args) {
  long start = System.currentTimeMillis();
  int sum = 0; // CHANGED HERE (from "Integer" object type to "int" primitive type)
  for (int i = 0; i < Integer.MAX_VALUE; i++) {
    sum += i;
  }
  System.out.println("Sum: " + sum);
  long end = System.currentTimeMillis();
  double total = (double) (end - start) / 1000;
  System.out.println("Time of execution: " + total + " seconds");
}
}

/* 1: 
* Sum: 1073741825
* Time of execution: 5.033 seconds
*/
/* 2: 
* Sum: 1073741825
* Time of execution: 0.636 seconds
*/