public class Person {
  /* There are three types of variables in Java:
   * (1) "member variables" - Variables declared within class scope (i.e. underneath declaration on first line of this file).
   * (2) "local variables" - Variables declared within method code blocks are not member variables. These variables are considered temporary in nature (i.e. they vanish when the method ends [meaning it goes out of scope or returns]).
   * (3) "parameter variables" - Variables that are declared in the method signature (i.e. between the parentheses). These variables are also considered temporary in nature. */
  /* "Member variables" may be called: 
  * "members,"
  * "attributes,"
  * "instance variables,"
  * "fields,"
  * or "properties."
  * These all refer to the same thing, but in Java are typically referred to as
  * "member variables" */
  
  private int age; // *age* - private member variable
  private String name; // *name* - private member variable
  private static int numberOfPeople = 0; // *numberOfPeople* - private static member variable; keeps track of the number of instances of People have been created

  /* The variable numberOfPeople is set as private, 
  * i.e. Only the class in which it is declared can see and access its value.
  * This contrasts with public variables, which are variables that every class has access to.
  * Because this is a static variable, it is only initialized once
  * (i.e. a single copy of this variable is being shared by all instances of the Person class)
  * Things that are going to be shared among all instance variables should be
  * set as static */
  public Person(int ageParam, String nameParam) { // This is the constructor; *ageParam* and *nameParam* - public parameter variables
    age = ageParam; // Assigning a value to a private member variable from the value of a public parameter variable
    name = nameParam; // Assigning a value to a private member variable from the value of a public parameter variable
    numberOfPeople++; // Adjusts the value of the private (static) member variable responsible for keeping track of the number of instances of the class that have been created (numberOfPeople)
    /* numberOfPeople is a good example of something that should be set as a static
     * variable because the number of People is not information specific to the
     * object, but rather the class itself. Therefore, the class should hold that
     * information. */
  }

  public static String caption() { // Static methods belong to the class (Person)
    return "This many instances of the Person class have been created: ";
  }

  public int getAge() { // Because this is a non-static method, it CANNOT be called by a static method such as PeopleCount() below
    this.age; // "this" refers to the object, i.e. the current instance that the getAge() method is being called on.
  }

  public static String peopleCount() { // Static methods belong to the class (Person)
    return String.format(caption() + numberOfPeople); // The static method caption() can only be called here because peopleCount() is a static method as well.
    // Static methods can only call other static methods
    /* The main reason that non-static methods cannot be called by static
    * methods (and vice versa) is because static methods belong to a class,
    * there is no instance that the method is running on
    * (this is why getAge() cannot be successfully called within the peopleCount() method)
    * The static method peopleCount() does not know what object the "this.age"
    * attribute in the non-static method getAge() is coming from.
    *
    * Also: private static attribute numberOfPeople being accessed inside the
    * static method (peopleCount()). */
  }

  // public static int peopleCount() {
  //   return numberOfPeople;
  // }

}