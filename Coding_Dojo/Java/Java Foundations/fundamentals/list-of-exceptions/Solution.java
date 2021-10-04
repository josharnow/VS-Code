import java.util.ArrayList;
import java.util.Random;

class ListOfExceptions {

    public static void main(String[] args) {
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");


        for(int i = 0; i < myList.size(); i++) {
            try {
                Integer castedValue = (Integer) myList.get(i);
            } catch(ClassCastException e) {
                System.out.println(e);
            }
        }
    }
}



// import java.util.ArrayList;
// import java.util.Random;
// class TestClassCastException extends Exception{}

// class Solution {

//   public static void main(String[] args) {
//     ArrayList<Object> myList = new ArrayList<Object>();
//     myList.add("13");
//     myList.add("hello world");
//     myList.add(48);
//     myList.add("Goodbye World");

//     for (int i = 0; i < myList.size(); i++) {
//       try {
//         Integer castedValue = (Integer) myList.get(i);
//         throw new TestClassCastException();
//       } catch (TestClassCastException e) {
//         System.out.println(e);
//       }
//     }
//   }

// }