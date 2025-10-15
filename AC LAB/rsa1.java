import java.security.*;
import java.util.*;
import javax.crypto.*;
public class rsa1 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        KeyPairGenerator kpg=KeyPairGenerator.getInstance("RSA");
        KeyPair keypair=kpg.generateKeyPair();
        PublicKey pu=keypair.getPublic();
        PrivateKey pv=keypair.getPrivate();
        System.out.print("Enter a message: ");
        String message = sc.nextLine();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pu);
        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
        String encText = Base64.getEncoder().encodeToString(encrypted);

        cipher.init(Cipher.DECRYPT_MODE, pv);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encText));
        String decText = new String(decrypted, "UTF-8");

        System.out.println("\nOriginal : " + message);
        System.out.println("Encrypted: " + encText);
        System.out.println("Decrypted: " + decText);

        sc.close();
    }
}
