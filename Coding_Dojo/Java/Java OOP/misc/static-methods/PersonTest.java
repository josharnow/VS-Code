public class PersonTest {
  public static void main(String[] args) {
    Person person1 = new Person(10, "Person1");
    Person person2 = new Person(5, "Person2");
    Person person3 = new Person(3, "Person3");
    // System.out.println(Person.numberOfPeople); 
    /* Person.numberOfPeople can only be
    * used if the numberOfPeople member variable in the Person class is set as
    * "public." If it is set as private, the PersonTest class will not be able
    * to access it.
    *
    * However, a private numberOfPeople member variable from the Person class
    * can still be indirectly accessed from the PersonTest class.
    * This is possible via the public peopleCount() method in Person class which itself
    * can (and does) directly access and return the value of numberOfPeople */
    System.out.println(Person.peopleCount());
  }
}
