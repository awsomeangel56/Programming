import java.util.*;
import javax.crypto.*;

public class des {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey key = keyGen.generateKey();

        System.out.print("Enter a message: ");
        String message = sc.nextLine();

        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypted = cipher.doFinal(message.getBytes("UTF-8"));
        String encText = Base64.getEncoder().encodeToString(encrypted);

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encText));
        String decText = new String(decrypted, "UTF-8");

        System.out.println("\nOriginal : " + message);
        System.out.println("Encrypted: " + encText);
        System.out.println("Decrypted: " + decText);

        sc.close();
    }
}
