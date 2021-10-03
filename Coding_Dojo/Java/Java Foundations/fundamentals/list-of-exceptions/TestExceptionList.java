import java.util.ArrayList;
public class TestExceptionList {
  public static void main(String[] args) {
    ExceptionList generator = new ExceptionList();

    ArrayList<Object> myList = new ArrayList<Object>();
    generator.appendList(myList, "13");
    generator.appendList(myList, "hello world");
    generator.appendList(myList, 48);
    generator.appendList(myList, "Goodbye World");

    System.out.println(myList);
    
    try{
      generator.testClassCastException(myList);
      System.out.println("Try success!?");
    } catch (ClassCastException e) {
      System.out.println("There was an error!");
      e.printStackTrace();
      System.out.printf("Index of the ArrayList where error occured: %d", e);
      System.out.printf("Value of the object that triggered the error: %s", e);
    }

    
    
    System.out.println(myList);
  }
}