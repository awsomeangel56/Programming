import java.math.BigInteger;
import java.util.*;
public class diffirand{
    public static void main(String[] args) {
        Random rand=new Random();
        BigInteger q=BigInteger.probablePrime(16,rand);
        BigInteger a=new BigInteger(8,rand).mod(q.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger xa=new BigInteger(8,rand).mod(q.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger xb=new BigInteger(8,rand).mod(q.subtract(BigInteger.ONE)).add(BigInteger.ONE);
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
