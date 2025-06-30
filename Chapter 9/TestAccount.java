import java.util.Date;

public class TestAccount {
    public static void main(String[] args){

        Account account = new Account(1122, 20000.0);
        Account.setAnnualInterestRate(4.5);

        account.deposit(3000);
        account.withdraw(2500);


        System.out.println(" After withdrawing $2500 and depositing $3000");
        System.out.println(" The balance is: $"+ account.getBalance() + ".\n the monthly interest is: "+ account.getMonthlyInterest() +
                " \nand the date is: " + account.getDatecreated() );

    }
}
class Account {

    private int id = 0;
    private double balance = 0;
    private static double annualInterestRate = 0;
    private Date dateCreated;

    Account(){
        dateCreated = new Date();
    }

    Account(int id, double balance){
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
}


