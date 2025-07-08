import java.util.Scanner;

public class TestAccount1 {
    public static void main(String[] args){
        id();
    }
    public static void id(){
        Scanner input = new Scanner(System.in);


        Account1[] account = new Account1[10];
        for (int i = 0 ;i<account.length ; i++)
            account[i]= new Account1(i ,100);

        System.out.print("Enter an id (0-9): ");
        int numberId = input.nextInt();

        while(numberId< 0 || numberId > 9){
            System.out.println("Please enter a correct id ");
            System.out.print("Enter an id: ");
            numberId = input.nextInt();
        }
        account[numberId].mainMenu();

    }

}
class Account1 {

    private int id = 0;
    private double balance = 0;


    Account1(int id, double balance){
        this.balance = balance;
        this.id = id;
    }

    public int getId() {

        return id;
    }
    public void setId(int id){
        this.id = id;

    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void withdraw( ){
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter amount to withdraw");
        double amount = input.nextDouble();
        balance -= amount;
        mainMenu();

    }
    public void deposit( ){
        Scanner input = new Scanner(System.in);

        System.out.println(" Enter amount to deposit");
        double amount = input.nextDouble();

        balance += amount;
        mainMenu();
    }
    public void checkBalance() {
        System.out.println("The balance is: "  + balance);
        mainMenu();

    }

    public void enterId(){
        Scanner input = new Scanner(System.in);


        System.out.print("Enter an id: ");
        int numberId = input.nextInt();

        if(numberId< 0 || numberId > 10){
            System.out.println("Please enter a correct id ");
            enterId();
        }
        else
            mainMenu();

    }
    public void mainMenu(){
        Scanner input = new Scanner(System.in);


        System.out.println(" Main menu ");
        System.out.println("1. check balance ");
        System.out.println("2. withdraw");
        System.out.println("3. deposit");
        System.out.println("4. exit");
        System.out.print(":");
        int number = input.nextInt();

        if (number == 1)
            checkBalance();
        else if (number == 2)
            withdraw();
        else if( number == 3)
            deposit();
        else if (number == 4)
            TestAccount1.id();

    }

}


