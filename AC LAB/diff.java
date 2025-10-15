import java.math.BigInteger;
import java.util.*;
public class diff{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter q: ");
        BigInteger q=sc.nextBigInteger();
        System.out.print("Enter a: ");
        BigInteger a=sc.nextBigInteger();
        System.out.print("Enter xa: ");
        BigInteger xa=sc.nextBigInteger();
        System.out.print("Enter xb: ");
        BigInteger xb=sc.nextBigInteger();
        BigInteger ya=a.modPow(xa,q);
        BigInteger yb=a.modPow(xb,q);
        System.out.println("Public key of A: "+ya);
        System.out.println("Public key of B: "+yb);
        BigInteger ka=yb.modPow(xa,q);
        BigInteger kb=ya.modPow(xb,q);
        System.out.println("Private key of A: "+ka);
        System.out.println("Private key of B: "+kb);
        
    }
}
