import java.util.*;
class RandomNumberGenerator extends Thread{
    int t=0;
    public void run(){
    Scanner s=new Scanner(System.in);
    Random random=new Random();
    while(t==0){
    int num=random.nextInt(100);
    System.out.println("Generated number: "+num);
    if(num%2==0){
        new SquareCalculator(num).start();
        }
    else{
        new CubeCalculator(num).start();
    }
    System.out.println("Want to continue? Enter 0 to continue and 1 to stop");
    int ch=s.nextInt();
    if(ch==1){
        t=1;
    }
    else{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
    }
}
}
class SquareCalculator extends Thread{
    int number;
    SquareCalculator(int number){
        this.number=number;
    }
    public void run(){
    System.out.println("Square of generated number: "+number+" is "+(number*number));
}
}
class CubeCalculator extends Thread{
    int number;
    CubeCalculator(int number){
        this.number=number;
    }
    public void run(){
    System.out.println("Cube of generated number: "+number+" is "+(number*number*number));
    }
}
class Rthread{
    public static void main(String[] args) {
        new RandomNumberGenerator().start();
    }
}
