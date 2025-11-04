import java.security.*;
import java.util.*;
public class md5dsa{
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message=sc.nextLine();
        
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] hash=md.digest(message.getBytes("UTF-8"));
        System.out.println("MD5 hash: "+Base64.getEncoder().encodeToString(hash));
        
        KeyPairGenerator kpg=KeyPairGenerator.getInstance("DSA");
        KeyPair keypair=kpg.generateKeyPair();
        PublicKey pu=keypair.getPublic();
        PrivateKey pv=keypair.getPrivate();
        Signature sig=Signature.getInstance("SHA256withDSA");
        sig.initSign(pv);
        sig.update(hash);
        byte[] disig=sig.sign();
        System.out.println("Digital signature: "+Base64.getEncoder().encodeToString(disig));
        sig.initVerify(pu);
        sig.update(hash);
        boolean veri=sig.verify(disig);
        System.out.println("Signature verified: "+veri);
    }
}