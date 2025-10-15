import java.security.*;
import java.util.*;
public class dss1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        KeyPairGenerator kpg=KeyPairGenerator.getInstance("DSA");
        KeyPair keypair=kpg.generateKeyPair();
        PublicKey pu=keypair.getPublic();
        PrivateKey pv=keypair.getPrivate();
        Signature sig=Signature.getInstance("SHA256withDSA");
        System.out.print("Enter a message: ");
        String message = sc.nextLine();
        sig.initSign(pv);
        sig.update(message.getBytes());
        byte[] disig=sig.sign();
        System.out.print("Digital signature: "+Base64.getEncoder().encodeToString(disig));
        sig.initVerify(pu);
        sig.update(message.getBytes());
        boolean veri=sig.verify(disig);
        System.out.println("Digital signature verified: "+veri);

        sc.close();
    }
}
