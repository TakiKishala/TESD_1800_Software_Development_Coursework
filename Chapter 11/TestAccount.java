import java.util.Date;

public class TestAccount {
    public static void main(String[] args){

        Account account = new Account(1122, 20000.0);
        Account.setAnnualInterestRate(4.5);
        account.deposit(3000);
        account.withdraw(2500);


        SavingsAccount sav = new SavingsAccount(1133, 15000);
        sav.setAnnualInterestRate(4.0);
        sav.withdraw(1600);

        CheckingAccount chk = new CheckingAccount(1144, 5000, 3000);
        chk.setAnnualInterestRate(2.5);
        chk.withdraw(2200);


        System.out.println("\n" + account);
        System.out.println("\n" + sav);
        System.out.println("\n" + chk);

        

    }
}
class Account {

    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    public Account(){
        dateCreated = new Date();
    }

    public Account(int id, double balance){
        this.balance = balance;
        this.id = id;
        this.dateCreated = new Date();
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;

    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;

    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public static void setAnnualInterestRate(double annualInterestRate){
        Account.annualInterestRate = annualInterestRate;

    }
    public Date getDatecreated (){
        return dateCreated;
    }
    public double getMonthlyInterestRate(){ 


        return annualInterestRate/12;
    }

    public double getMonthlyInterest(){

        return  balance * (getMonthlyInterestRate()/100);

    }
    public void withdraw( double amount){
         balance -= amount;


    }
    public void deposit( double amount){
       balance += amount;
    }
    @Override
    public String toString() {
        return "Account ID: " + id +
                "\nBalance: $" + balance +
                "\nAnnual Interest Rate: " + annualInterestRate + "%" +
                "\nDate Created: " + dateCreated;
    }
}

class CheckingAccount extends Account{

    private double overdraftLimit;

    public CheckingAccount(int id, double balance, double overdraftLimit) {
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public void setOverdraftLimit(double limit) {
        overdraftLimit = limit;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() - amount < -overdraftLimit) {
            System.out.println("CheckingAccount: Overdraft limit exceeded. Withdrawal denied.");
        }
        else {
            super.withdraw(amount);
        }
    }

    @Override
    public String toString() {
        return "Checking Account\n" + super.toString() +
                "\nOverdraft Limit: $" + overdraftLimit;
    }
}

class SavingsAccount extends Account{

    public SavingsAccount(int id, double balance) {
        super(id, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > getBalance()) {
            System.out.println("SavingsAccount: Insufficient funds. Withdrawal denied.");
        } else {
            super.withdraw(amount);
        }
    }

    @Override
    public String toString() {
        return "Savings Account\n" + super.toString();
    }

}


