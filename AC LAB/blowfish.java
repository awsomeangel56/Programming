import java.util.*;
import javax.crypto.*;

public class blowfish{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Plaintext: ");
        String plain = sc.nextLine();
       
        KeyGenerator k = KeyGenerator.getInstance("Blowfish");
        k.init(128);
        SecretKey key = k.generateKey();
       
        Cipher cipher = Cipher.getInstance("Blowfish");
       
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(plain.getBytes("UTF-8"));
        String enc = Base64.getEncoder().encodeToString(encrypted);
       
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(enc));
        String dec = new String(decrypted, "UTF-8");
       
        System.out.println("Original : " + plain);
        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
       
        sc.close();
    }
}