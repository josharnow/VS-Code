import java.util.ArrayList;
class ClassCastException extends Exception{}

public class ExceptionList {
  public ArrayList<Object> appendList(ArrayList<Object> list, Object item) {
    list.add(item);

    return list;
  }

  public void testClassCastException(ArrayList<Object> list) throws ClassCastException {
    // boolean hasError = false;

    for (int i = 0; i < list.size(); i++) {
      Integer castedValue = (Integer) list.get(i);
    }

    // if (hasError == false) {
    //   return true;
    // }




  }
}
