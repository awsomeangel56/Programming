import java.util.*;
class Account{
    int acntno;
    double bal;
    public Account(int acntno, double inbal){
        this.acntno=acntno;
        this.bal=inbal;
    }
    public synchronized void displayBalance(){
        System.out.print("\nAccount No: "+acntno+", Balance: "+bal);
    }
    public synchronized void deposit(double amount){
        if(amount>0){
            bal+=amount;
        System.out.println("\nAmount deposited: "+amount);
        displayBalance();
        }
        else{
            System.out.println("Inavlid amount to deposit!!");
        }
    }
    public synchronized void withdraw(double amount){
        if(amount>0 && amount<=bal){
            bal-=amount;
            System.out.println("\nAmount withdrawn: "+amount);
        displayBalance();
        }
    }
}
class Deposit extends Thread{
    Account account;
    double amount;
    public Deposit(Account account, double amount){
        this.account=account;
        this.amount=amount;
    }
    @Override
    public void run(){
        account.deposit(amount);
    }
}
class Withdraw extends Thread{
    Account account;
    double amount;
    public Withdraw(Account account, double amount){
        this.account=account;
        this.amount=amount;
    }
    @Override
    public void run(){
        account.withdraw(amount);
    }
}
public class Threads{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter account no: ");
        int acntno=s.nextInt();
        System.out.println("Enter initial balance: ");
        double inbal=s.nextDouble();
        Account account=new Account(acntno,inbal);
        System.out.println("Enter amount to deposit:  ");
        double depamt=s.nextDouble();
        System.out.println("Enter amount to withdraw:  ");
        double withamt=s.nextDouble();
        Deposit deposit=new Deposit(account, depamt);
        Withdraw withdraw=new Withdraw(account, withamt);
        deposit.start();
        withdraw.start();
        try {
            deposit.join();
            withdraw.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted "+e.getMessage());
        }
        finally{
            s.close();
        }
    }
}























