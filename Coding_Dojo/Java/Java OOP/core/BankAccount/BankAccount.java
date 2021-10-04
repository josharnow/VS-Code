import java.util.Random;
public class BankAccount {
  // Attributes (belong to the object instances created using class BankAccount)
    // private long accountNumber = accountGen();
  private double checkingBalance;
  private double savingsBalance;
  private int accountNumber;

  // Class members (belong to the class BankAccount)
  private static int numOfAccounts = 0;


  /**
   * OVERLOADED CONSTRUCTOR METHODS
   * Constructor that takes no arguments, creating accounts for a user with
   * $0.00 each.
   */
  public BankAccount() {
    checkingBalance = 0;
    savingsBalance = 0;
    accountNumber = BankAccount.generateRandomAccountNum();
    // accountNumber = BankAccount.generateRandomAccountNum(9);
    ++numOfAccounts;
  }

  /**
   * Constructor that takes 2 arguments (double checkingBalance, double
   * savingsBalance), creating checking and savings accounts for a user with a
   * starting balance equal to the checkingBalance and savingsBalance arguments.
   * @param checkingBalance Starting checking account balance
   * @param savingsBalance  Starting savings account balance
   */
  public BankAccount(double checkingBalance, double savingsBalance) {
    this.checkingBalance = checkingBalance;
    this.savingsBalance = savingsBalance;
    accountNumber = BankAccount.generateRandomAccountNum();
    // accountNumber = BankAccount.generateRandomAccountNum(9);
    ++numOfAccounts; // Increments the numOfAccounts count
  }

  /**
   * Constructor that takes 2 arguments (String accountType, double
   * initialBalance), creating checking and savings accounts for a user with a
   * starting balance of initialBalance in the specified accountType (either
   * "checking" or "savings") and a balance of $0.00 in the other account created.
   * @param accountType
   * @param initialBalance
   */
  public BankAccount(String accountType, double initialBalance) {
    if (accountType.equals("checking")) {
      checkingBalance = initialBalance;
      savingsBalance = 0;
    } else if (accountType.equals("savings")) {
      checkingBalance = 0;
      savingsBalance = initialBalance;
    }
    accountNumber = BankAccount.generateRandomAccountNum();
    // accountNumber = BankAccount.generateRandomAccountNum(9);
    ++numOfAccounts; // Increments the numOfAccounts count
  }



  // GETTERS
  /**
   * Gets the balance of a checking account.
   * @return The balance of a checking account [double]
   */
  public double getCheckingBalance() {
    return checkingBalance;
  }

  /**
   * Gets the balance of a savings account.
   * @return The balance of a savings account [double]
   */
  public double getSavingsBalance() {
    return savingsBalance;
  }

  /**
   * Gets the number of accounts that have been created at the bank.
   * @return The number of accounts created at the bank (checking/savings considered single account) [int]
   */
  public static int getNumOfAccounts() {
    return numOfAccounts;
  }

  /**
   * Gets the grand total balance of an account (i.e. checking balance + savings
   * balance).
   * @return The grand total balance of an account (i.e. checking balance + savings balance) [double]
   */
  public double getGrandTotalBalance() {
    return checkingBalance + savingsBalance;
  }

  /**
   * Gets the account number associated with the account
   * @return The account number associated with the account [int]
   */
  public int getAccountNum() {
    return accountNumber;
  }

  //SETTERS
  /**
   * Sets the balance of a checking account.
   * @param checkingBalance Value to set the checking account balance to
   */
  public void setCheckingBalance(double checkingBalance) {
    this.checkingBalance = checkingBalance; // When the name assigned to the current object (within the context of an instance method or constructor) is identical to the name assigned to a parameter, appending the "this" keyword is REQUIRED. Otherwise, appending "this" is optional. 
  }

  /**
   * Sets the balance of a savings account.
   * @param savingsBalance Value to set the savings account balance to
   */
  public void setSavingsBalance(double savingsBalance) {
    this.savingsBalance = savingsBalance; // When the name assigned to the current object (within the context of an instance method or constructor) is identical to the name assigned to a parameter, appending the "this" keyword is REQUIRED. Otherwise, appending "this" is optional. 
  }

  /**
   * Makes a deposit equal to the value specified in the "amount" argument. Depositing in checking/savings is determined specified "accountType" argument.
   * @param accountType "checking" or "savings"
   * @param amount Amount to deposit
   */
  public void depositUSD(String accountType, double amount) {
    if (accountType.equals("checking")) {
      this.setCheckingBalance(checkingBalance + amount); 
    } else if (accountType.equals("savings")) {
      this.setSavingsBalance(savingsBalance + amount); 
    }
  }

  /**
   * Makes a withdrawal equal to the value specified in the "amount" argument if the account balance is greater than or equal to the withdrawal requested. Withdrawing in checking/savings is determined specified "accountType" argument.
   * 
   * @param accountType "checking" or "savings"
   * @param amount Amount to withdraw
   */
  public void withdrawUSD(String accountType, double amount) {
    if (accountType.equals("checking")) {
      if (amount > checkingBalance) {
        System.out.printf("You cannot withdraw $%,.2f because it exceeds your checking account balance by $%,.2f. Please withdraw $%,.2f or less.%n", amount, amount - checkingBalance, checkingBalance);
      } else {
        this.setCheckingBalance(this.checkingBalance - amount);
        }
    } else if (accountType.equals("savings")) {
      if (amount > savingsBalance) {
        System.out.printf(
            "You cannot withdraw $%,.2f because it exceeds your savings account balance by $%,.2f. Please withdraw $%,.2f or less.%n",
            amount, amount - savingsBalance, savingsBalance);
      } else {
        this.setSavingsBalance(savingsBalance - amount);
      }
    }
  }

  // Private method - used locally within BankAccount class
  /**
   * Generates a random account number on the interval [1, 10^10).
   * @return A random account number on the interval [1, 10^10) [int]
   */
  // private static int generateRandomAccountNum(int length) {
  private static int generateRandomAccountNum() {
    Random randMachine = new Random();

    int randomAccountNum = randMachine.nextInt(999999999) + 1;
    // int randomAccountNum = randMachine.nextInt(length) + 1;
    // int randomAccountNum = randMachine.nextInt(length - 1) + 1;
    return randomAccountNum;
  }
}

// Random

// HashMap