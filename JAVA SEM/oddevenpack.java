class Shared{
    private boolean isOdd=true;
    synchronized void print(int num){
    while(isOdd!=(num%2!=0)){
        try {
            wait();
        } catch (InterruptedException e) {
            System.out.print(e);
        }
    }
    System.out.print(num+" ");
    isOdd=!isOdd;
    notify();
    }
}
class NumberThread extends Thread{
    private final Shared shared;
    private final int start;
    NumberThread(Shared shared, int start){
        this.shared=shared;
        this.start=start;
    }
    public void run(){
        for(int i=start;i<=100;i+=2){
            shared.print(i);
        }
    }
}
public class oddevenpack{
    public static void main(String[] args) {
        Shared shared=new Shared();
        new NumberThread(shared,1).start();
        new NumberThread(shared,2).start();

    }
}