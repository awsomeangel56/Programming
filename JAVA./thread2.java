import java.util.*;
class RandomNumberGenerator extends Thread {
    int t=0;;
    public void run() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        while (t==0) {
            int num = random.nextInt(100);
            System.out.println("Generated Number: " + num);
            if (num % 2 == 0) {
                new evengen(num).start();
            } else {
                new oddgen(num).start();}
            System.out.println("Want to continue? Enter 0 to continue, 1 to stop:");
            int n = sc.nextInt();
            if (n == 1) {
                t=1;} 
            else {
                try {
                    Thread.sleep(1000);} 
                catch (InterruptedException e) {
                    System.out.println(e.getMessage());}}}}}
class evengen extends Thread {
    int number;
    evengen(int number) {
        this.number = number;}
    public void run() {
        for(int i=1;i<number;i++){
            if(i%2==0){
                System.out.println("Even number: " +i);}}}}
class oddgen extends Thread {
    int number;
    oddgen(int number) {
        this.number = number;}
    public void run() {
        for(int i=1;i<number;i++){
            if(i%2!=0){
                System.out.println("Odd number: " + i);}}}}
public class thread2 {
    public static void main(String[] args) {
        new RandomNumberGenerator().start();}}