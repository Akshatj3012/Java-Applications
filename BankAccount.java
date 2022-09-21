package Project;
import java.util.Scanner;
public class BankAccount {
    private String customername;
    private String cid;
    private float balance;
    private float previoustransaction;

    public BankAccount(String cname,String cid){
        this.customername=cname;
        this.cid=cid;
    }

    void deposit(float amt){
        this.balance=this.balance+amt;
        previoustransaction=amt;
        System.out.println("Deposited!!!");
    }
    void withdraw(float amt) {
        if (this.balance < amt) {
            System.out.println("Insufficient balance!!!");
        } else {
            this.balance = this.balance - amt;
            previoustransaction = -amt;
        }
    }

    void getPrevioustransaction() {
        if (previoustransaction>0){
            System.out.println("Deposited: "+previoustransaction);
        }else{
            System.out.println("Withdrawn: "+Math.abs(previoustransaction));
        }
    }
    void checkBalance(){
        System.out.println(this.balance);
    }
    void showMenu(){
        Scanner sc=new Scanner(System.in);
        char option;
        System.out.println("Hello "+this.customername);
        System.out.println("Welcome to our Bank Services page");
        System.out.println("\nA. Check balance\nB. Deposit\nC. Withdraw\nD. Check previous transaction\nE. Exit");

//        System.out.println();
        do{
//            System.out.println("*****************************************************************");
            System.out.println();
            System.out.println("Enter an option");
            option=sc.next().charAt(0);
//            System.out.println("*****************************************************************");
            switch (option){
                case 'B':
                    System.out.print("Enter amount to deposit: ");
                    float amt=sc.nextFloat();
                    deposit(amt);
                    break;
                case 'C':
                    System.out.println("Enter amount to withdraw: ");
                    float amnt=sc.nextFloat();
                    withdraw(amnt);
                    break;
                case 'D':
                    getPrevioustransaction();
                    break;
                case 'A':
                    checkBalance();
                    break;
                case 'E':
                    break;
                default:
                    System.out.println("Error occured! Enter another character");
                    break;
            }
        }while(option!='E');
        System.out.println("Thank you for visiting!!!");

    }
    public static void main(String[] args){
        BankAccount obj=new BankAccount("Akshat","BA12334");
        obj.showMenu();
    }
}
