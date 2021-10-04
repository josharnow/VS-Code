// import java.util.ArrayList;
// import org.apache.commons.lang3.StringUtils;
// import com.google.common.primitives.Ints;
// import java.util.Random;
import java.lang.Character;
public class TestPuzzleJava {
  public static void main(String[] args) {
    PuzzleJava generator = new PuzzleJava();

    // getTenRolls
    int[] randomRolls = generator.getTenRolls();

    System.out.println("----- Ten Random Rolls Test -----");
    byte i = 0;
    for (int num : randomRolls) {
      ++i;
      System.out.printf("Roll #%d: %d %n", i, num);
    }

    // getRandomLetter
    char randLetter = generator.getRandomLetter();
    char upperCaseRandLetter = Character.toUpperCase(randLetter);

    System.out.println("----- Random Letter Test -----");

    System.out.printf("Lower case: %c%n", randLetter);
    System.out.printf("Upper case: %C%n", randLetter);
    // System.out.printf("Lower case: " + randLetter);
    // System.out.printlf("Upper case: " + upperCaseRandLetter);
    
    // generatePassword
    String password = generator.generatePassword();
    System.out.println("----- Generate Password Test -----");
    System.out.println(password);
    
    // getNewPasswordSet
    String[] passwordSet = generator.getNewPasswordSet(5);
    System.out.println("----- Generate Password Set Test -----");
    System.out.println(String.join(", ", passwordSet));
    
    // // shuffleArray
    // String[] shuffleArray = generator.shuffleArray(passwordSet);
    // System.out.println("----- Shuffle Array Test -----");
    // System.out.println(String.join(", ", shuffleArray));
  }
}