import java.util.Date;

public class AlfredQuotes {

  /**
   * Returns a generic greeting that Alfred will say to anyone.
   * 
   * @return A generic greeting that Alfred will say to anyone [String]
   */
  public String basicGreeting() {
    return "Hello, lovely to see you. How are you?";
  }

  /**
   * Returns a greeting that includes the person's name.
   * 
   * @param name [String]
   * @return A greeting that includes the person's name [String]
   */
  public String guestGreeting(String name) {
    return String.format("Hello %s. Lovely to see you.", name);
  }

  /**
   * Returns a greeting that includes the person's name as well as thew day period.
   * 
   * @param name [String]
   * @param datePeriod [String]
   * @return A greeting that includes the person's name as well as the day
   * period [String] [String]
   */
  public String guestGreeting(String name, String datePeriod) {
    return String.format("Good %s, %s. Lovely to see you.",datePeriod, name);
  }

  /**
   * Returns a polite announcement of the current date and time.
   * 
   * @return A polite announcement of the current date and time [String]
   */
  public String dateAnnouncement() {
    Date date = new Date();

    return String.format("It is currently %tc", date);
  }

  /**
   * Accepts any string of conversation and returns appropriate response.
   * 
   * @param conversation [String]
   * 
   * @return An appropriate response based on the input conversation string: (1) If "Alexis" appears in the conversation (in the string) return a snarky response [String], (2) If "Alfred" is in the conversation return an obliging response [String], or (3) If neither name is found, return an appropriate response [String]
   */
  public String respondBeforeAlexis(String conversation) {
    int isTriggeredAlexis = conversation.indexOf("Alexis");
    int isTriggeredAlfred = conversation.indexOf("Alfred");

    if (isTriggeredAlexis != -1) {
      return "Right away, sir. She certainly isn't sophisticated enough for that.";
    } else if (isTriggeredAlfred != -1) {
      return "At your service. As you wish, naturally.";
    } else {
      return "Right. And with that I shall retire.";
    }
  }

  // NINJA BONUS
  // See the specs to overload the guessGreeting method
      // SENSEI BONUS
      // Write your own AlfredQuote method using any of the String methods you have
      // learned!
}