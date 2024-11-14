import java.util.*;
class OddNumberException extends Exception{
    public OddNumberException(String message){
        super(message);
    }
}
public class odd {
public static void Checkoddnumber(int number) throws OddNumberException{
    if(number%2!=0){
    throw new OddNumberException("Number "+number+ " is odd");
}
    else{
        System.out.println("Number is even");
    }
}
public static void main(String[] args) {
    Scanner s=new Scanner(System.in);
    try{
    System.out.println("Enter the number: ");
    int number=s.nextInt();
    Checkoddnumber(number);
    }
    catch(OddNumberException e){
        System.out.println(e);
    }
    }
}

