import java.util.*;
import javax.crypto.*;
public class desj{
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        KeyGenerator keygen=KeyGenerator.getInstance("DES");
        SecretKey key=keygen.generateKey();
        System.out.print("Enter the message: ");
        String message=sc.nextLine();
        Cipher cipher=Cipher.getInstance("DES");
        cipher.init(cipher.ENCRYPT_MODE,key);
        byte[] encrypted=cipher.doFinal(message.getBytes("UTF-8"));
        String encText=Base64.getEncoder().encodeToString(encrypted);
        cipher.init(cipher.DECRYPT_MODE,key);
        byte[] decrypted=cipher.doFinal(Base64.getDecoder().decode(encText));
        String decText=new String(decrypted,"UTF-8");
        System.out.println("Original Message: "+message);
        System.out.println("Encrypted text: "+encText);
        System.out.println("Decrypted text: "+decText);
    }
}
