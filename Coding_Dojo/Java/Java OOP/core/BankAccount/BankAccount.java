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
    return this.checkingBalance + this.savingsBalance;
  }

  /**
   * Gets the account number associated with the account
   * @return The account number associated with the account [int]
   */
  public int getAccountNum() {
    return this.accountNumber;
  }

  //SETTERS
  /**
   * Sets the balance of a checking account.
   * @param checkingBalance Value to set the checking account balance at
   */
  public void setCheckingBalance(double checkingBalance) {
    this.checkingBalance = checkingBalance;
  }

  /**
   * 
   * @param savingsBalance
   */
  public void setSavingsBalance(double savingsBalance) {
    this.savingsBalance = savingsBalance;
  }

  public void depositUSD(String accountType, double amount) {
    if (accountType.equals("checking")) {
      this.setCheckingBalance(this.checkingBalance + amount); 
    } else if (accountType.equals("savings")) {
      this.setSavingsBalance(this.savingsBalance + amount); 
    }
  }

  public void withdrawUSD(String accountType, double amount) {
    if (accountType.equals("checking")) {
      if (amount > this.checkingBalance) {
        System.out.printf("You cannot withdraw $%,.2f because it exceeds your checking account balance by $%,.2f. Please withdraw $%,.2f or less.%n", amount, amount - this.checkingBalance, this.checkingBalance);
      } else {
        this.setCheckingBalance(this.checkingBalance - amount);
        }
    } else if (accountType.equals("savings")) {
      if (amount > this.savingsBalance) {
        System.out.printf(
            "You cannot withdraw $%,.2f because it exceeds your savings account balance by $%,.2f. Please withdraw $%,.2f or less.%n",
            amount, amount - this.savingsBalance, this.savingsBalance);
      } else {
        this.setSavingsBalance(this.savingsBalance - amount);
      }
    }
  }

  // Private method - used locally within BankAccount class
  private static int generateRandomAccountNum() {
    Random randMachine = new Random();

    int randomAccountNum = randMachine.nextInt(999999999) + 1;
    return randomAccountNum;
  }
}