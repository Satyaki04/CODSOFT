import java.util.*;

class bankAccount{
    double balance=0;
}

class ATM extends bankAccount{
    void withdraw(double amount){
        if(balance<amount){
            System.out.println("Insufficient balance!!");
        }
        else{ 
            balance-=amount; 
            System.out.println("Transaction successfull!!");
        }
    }
    void deposit(double amount){
        balance+=amount;
        System.out.println("Amount depositted!!");
    }
    void checkBalance(){
        System.out.println("Account Balance - "+balance+"/-");
    }
}

public class task3CodSoft {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ATM atm=new ATM();
        System.out.println("---Welcome to our ATM---");
        char q='Y';
        while(q=='Y'){
            System.out.println("    1. Deposit\n    2. Withdraw\n    3. Check Balance\nEnter the option number:");
            int opt=sc.nextInt();
            if(opt==1){
                System.out.println("Enter amount:");
                double ammt=sc.nextDouble();
                atm.deposit(ammt);
            }
            else if(opt==2){
                System.out.println("Enter amount:");
                double ammt=sc.nextDouble();
                atm.withdraw(ammt);
            }
            else if(opt==3){
                atm.checkBalance();
            }
            else{ System.out.println("Invalid input! Please enter again"); }
            System.out.println("-----------------------");
            System.out.println("Do you want to continue?(Y/N)");
            q=sc.next().charAt(0);
        }
        System.out.println("---Thank You!---");
    }
}
