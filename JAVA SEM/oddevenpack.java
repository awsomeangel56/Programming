package evenpackage;
public class Even{
    public static void oddoreven(int num){
        if(num%2==0){
            System.out.print("Number is even");
        }
        else{
            System.out.println("Number is odd");
        }
    }
}
import evenpackage.Even;
public class oddevenpack{
    public static void main(String[] args) {
        Even obj=new Even();
        obj.oddoreven(15);
    }
}