import java.util.Scanner;
class Account {
    int acntno;
    double bal;
    public Account(int acntno, double inbal) {
        this.acntno = acntno;
        this.bal = inbal;}
    public synchronized void displayBalance() {
        System.out.println("Account No: " + acntno+ ", Balance: " + bal);}
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            bal+= amount;
            System.out.println("Deposited: " + amount);
            displayBalance();
        } else {
            System.out.println("Invalid deposit amount");}}
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= bal) {
            bal-= amount;
            System.out.println("Withdrew: " + amount);
            displayBalance();
        } else {
            System.out.println("Invalid or insufficient funds for withdrawal");}}}
class Deposit extends Thread {
    Account account;
    double amount;
    public Deposit(Account account, double amount) {
        this.account = account;
        this.amount = amount;}
    public void run() {
        account.deposit(amount);}}
class Withdraw extends Thread {
    Account account;
    double amount;
    public Withdraw(Account account, double amount) {
        this.account = account;
        this.amount = amount;}
    public void run() {
        account.withdraw(amount);}}
public class thread3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int acntno= scanner.nextInt();
        System.out.print("Enter initial balance: ");
        double inbal= scanner.nextDouble();
        Account account = new Account(acntno, inbal);
        System.out.print("Enter amount to deposit: ");
        double depamt= scanner.nextDouble();
        System.out.print("Enter amount to withdraw: ");
        double withamt= scanner.nextDouble();
        Deposit deposit= new Deposit(account, depamt);
        Withdraw withdraw= new Withdraw(account, withamt);
        deposit.start();
        withdraw.start();
        try {
            deposit.join();
            withdraw.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());}}}