import java.util.Random;
// import java.util.HashMap;
public class BankAccountTest {
  public static void main(String[] args) {
    Random randMachine = new Random();
    
    // Creating bank accounts
    BankAccount account1 = new BankAccount();
    BankAccount account2 = new BankAccount(randMachine.nextInt(1001), randMachine.nextInt(1001));

    // Get checking account balances
    System.out.println("----- Get Checking Account Balances Test -----");
    System.out.printf("Checking account balance for account #%09d: $%,.2f%n", account1.getAccountNum(), account1.getCheckingBalance());
    System.out.printf("Checking account balance for account #%09d: $%,.2f%n", account2.getAccountNum(), account2.getCheckingBalance());
    
    // Get savings account balances
    System.out.println("\n----- Get Savings Account Balances Test -----");
    System.out.printf("Savings account balance for account #%09d: $%,.2f%n", account1.getAccountNum(), account1.getSavingsBalance());
    System.out.printf("Savings account balance for account #%09d: $%,.2f%n", account2.getAccountNum(), account2.getSavingsBalance());
    
    // Get grand total account balances
    System.out.println("\n----- Get Grand Total Account Balances Test -----");
    System.out.printf("Grand total account balance for account #%09d: $%,.2f%n", account1.getAccountNum(), account1.getGrandTotalBalance());
    System.out.printf("Grand total account balance for account #%09d: $%,.2f%n", account2.getAccountNum(), account2.getGrandTotalBalance());
    
    // Get total number of accounts
    System.out.println("\n----- Get Total Number of Accounts Test -----");
    System.out.printf("There are %d bank accounts%n", BankAccount.getNumOfAccounts());
    
    // Set/Get checking account balances
    System.out.println("\n----- Set/Get Checking Account Balances Test -----");
    account1.setCheckingBalance(randMachine.nextInt(1000));
    account2.setCheckingBalance(randMachine.nextInt(1000));

    System.out.printf("Checking account balance for account #%09d: $%,.2f%n", account1.getAccountNum(), account1.getCheckingBalance());
    System.out.printf("Checking account balance for account #%09d: $%,.2f%n", account2.getAccountNum(), account2.getCheckingBalance());
    
    // Deposit
    double account1CheckingDeposit = randMachine.nextInt(1000);
    double account1SavingsDeposit = randMachine.nextInt(1000);
    double account2CheckingDeposit = randMachine.nextInt(1000);
    double account2SavingsDeposit = randMachine.nextInt(1000);
    
    System.out.println("\n----- Deposit Test -----");
    System.out.printf("Depositing $%,.2f into checking account #%09d%n", account1CheckingDeposit, account1.getAccountNum());
    account1.depositUSD("checking", account1CheckingDeposit);
    System.out.printf("New balance in checking account #%09d: $%,.2f%n", account1.getAccountNum(), account1.getCheckingBalance());

    System.out.printf("Depositing $%,.2f into savings account #%09d%n", account1SavingsDeposit, account1.getAccountNum());
    account1.depositUSD("savings", account1SavingsDeposit);
    System.out.printf("New balance in savings account #%09d: $%,.2f%n", account1.getAccountNum(), account1.getSavingsBalance());

    System.out.printf("\nDepositing $%,.2f into checking account #%09d%n", account2CheckingDeposit, account2.getAccountNum());
    account2.depositUSD("checking", account2CheckingDeposit);
    System.out.printf("New balance in checking account #%09d: $%,.2f%n", account2.getAccountNum(), account2.getCheckingBalance());

    System.out.printf("Depositing $%,.2f into savings account #%09d%n", account2SavingsDeposit, account2.getAccountNum());
    account2.depositUSD("savings", account2SavingsDeposit);
    System.out.printf("New balance in savings account #%09d: $%,.2f%n", account2.getAccountNum(), account2.getSavingsBalance());
    
    // Withdrawal
    double account1CheckingWithdrawal = randMachine.nextInt(1000);
    double account1SavingsWithdrawal = randMachine.nextInt(1000);
    double account2CheckingWithdrawal = randMachine.nextInt(1000);
    double account2SavingsWithdrawal = randMachine.nextInt(1000);

    System.out.println("\n----- Withdrawal Test -----");
    System.out.printf("Attempting to withdraw $%,.2f from checking account #%09d...%n", account1CheckingWithdrawal, account1.getAccountNum());
    account1.withdrawUSD("checking", account1CheckingWithdrawal);
    System.out.printf("New balance in checking account #%09d: $%,.2f%n", account1.getAccountNum(), account1.getCheckingBalance());

    System.out.printf("Attempting to withdraw $%,.2f from savings account #%09d...%n", account1SavingsWithdrawal, account1.getAccountNum());
    account1.withdrawUSD("savings", account1SavingsWithdrawal);
    System.out.printf("New balance in savings account #%09d: $%,.2f%n", account1.getAccountNum(), account1.getSavingsBalance());

    System.out.printf("\nAttempting to withdraw $%,.2f from checking account #%09d...%n", account2CheckingWithdrawal, account2.getAccountNum());
    account2.withdrawUSD("checking", account2CheckingWithdrawal);
    System.out.printf("New balance in checking account #%09d: $%,.2f%n", account2.getAccountNum(), account2.getCheckingBalance());

    System.out.printf("Attempting to withdraw $%,.2f from savings account #%09d...%n", account2SavingsWithdrawal, 
        account2.getAccountNum());
    account2.withdrawUSD("savings", account2SavingsWithdrawal);
    System.out.printf("New balance in savings account #%09d: $%,.2f%n", 
        account2.getAccountNum(), account2.getSavingsBalance());

    // Get grand total account balances 2
    System.out.println("\n----- Get Grand Total Account Balances Test 2 -----");
    System.out.printf("Grand total account balance for account #%09d: $%,.2f%n", 
        account1.getAccountNum(), account1.getGrandTotalBalance());
    System.out.printf("Grand total account balance for account #%09d: $%,.2f%n", 
        account2.getAccountNum(), account2.getGrandTotalBalance());
    
    // Get account numbers
    System.out.println("\n----- Get Account Numbers Test -----");
    System.out.printf("Your account number is #%09d%n", account1.getAccountNum());
    System.out.printf("Your account number is #%09d%n", account2.getAccountNum());

  }
}