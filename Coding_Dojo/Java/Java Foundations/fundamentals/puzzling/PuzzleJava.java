import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.lang.Character;
import java.util.Random;
public class PuzzleJava {
  /**
 * Generates and returns an array with 10 random numbers between 1 and 20 inclusive.
 * @return Array with 10 random numbers in Domain {x | 1 <= x <= 20} [int[]]
 */
  public int[] getTenRolls() {
    Random randMachine = new Random();
    
    int[] arr; // Variable Declaration
    arr = new int[10]; // Initialization
    
    for (byte i = 0; i < arr.length; ++i) {
      int randomNumber = randMachine.nextInt(20) + 1;
      arr[i] = randomNumber;
    }
    
    return arr;
      }
    
  /**
   * Returns a random character between the letters a and z, inclusive.
   * @return A random character from the Latin alphabet [char]
   */
  public char getRandomLetter() {
    Random randMachine = new Random();

    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    int randLetterIdx = randMachine.nextInt(25);
    char randLetter = alphabet[randLetterIdx];

    return randLetter;
  }
  
  /**
   * Uses getRandomLetter() method to create a random string of eight characters.
   * @return A random string of eight characters [String]
   */
  public String generatePassword() {
    String password = "";

    for (byte i = 0; i < 8; ++i) {
      password += getRandomLetter();
    }
    
    return password;
  }

  /**
   * Creates an array of eight character words, given an int length provided as an argument.
   * @param numPasswords Number of passwords to generate [int]
   * @return An array of passwords [String[]]
   */
  public String[] getNewPasswordSet(int numPasswords) {
    String[] arr; // Variable Declaration
    arr = new String[numPasswords]; // Initialization

    for (byte i = 0; i < numPasswords; ++i) {
      arr[i] = generatePassword();
    }

    return arr;
  }

  /**
   * Takes an array and mixes up all values in a pseudo-random way.
   * @param arr Array to shuffle [String[]]
   * @return A shuffled array [String[]]
   */
  public String[] shuffleArray(String[] arr) {
    Random randMachine = new Random();

    String[] shuffledArr = new String[arr.length];

    int currentIdx = 0;
    int[] usedIdxArr = new int[arr.length];
    for (byte i = 0; i < arr.length; ++i) {
      // boolean usedIdx = true;
      int idxRemaining = arr.length - currentIdx;
      // int randIdx = randMachine.nextInt(arr.length) + 1;
      // int randIdx = randMachine.nextInt(idxRemaining) + currentIdx + 1;
      // int randIdx = randMachine.nextInt(idxRemaining + 1) + currentIdx;
      int randIdx = randMachine.nextInt(idxRemaining) + currentIdx;
      
      System.out.println(randIdx);
      System.out.println(Arrays.toString(usedIdxArr));
      
      
      if (i == 0) {
        shuffledArr[i] = arr[randIdx];
          System.out.println(Arrays.toString(usedIdxArr));
        ++currentIdx;
      } else if (usedIdxArr[randIdx] != randIdx) {
        // usedIdx = false;
        shuffledArr[i] = arr[randIdx];
        usedIdxArr[randIdx] = randIdx;
          System.out.println(Arrays.toString(usedIdxArr));
        ++currentIdx;
      } else {
        i--;
        // break;
      }
      


      // int randIdx = randMachine.nextInt(arr.length) + 1;

      // // if (shuffledArr[i] == null) {
      // //   shuffledArr[i] = arr[randIdx];
      // // } else {
      // //   --i;
      // // }



      
      
      // ++currentIdx;


      // for (String idxValue : shuffledArr) {
      //   idxValue = 
      // }

      // int randShuffledArrIdx = randMachine.nextInt(arr.length) + 1;

      // shuffledArr[randShuffledArrIdx] = arr[randArrIdx];

    }

    // for (byte i = 0; i < arr.length; ++i) {
    //   int randArrIdx = randMachine.nextInt(arr.length) + 1;
    //   int randShuffledArrIdx = randMachine.nextInt(arr.length) + 1;

    //   shuffledArr[randShuffledArrIdx] = arr[randArrIdx];
    // }

    return shuffledArr;
  }
}