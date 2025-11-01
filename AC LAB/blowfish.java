import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
public class blowfish{
    public static void main(String[] args) throws Exception{
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter message: ");
    String message=sc.nextLine();
    System.out.println("Enter key: ");
    String k1=sc.nextLine();
    byte[] ke=k1.getBytes("UTF-8");
    SecretKeySpec key=new SecretKeySpec(ke,"BLOWFISH");
    Cipher cipher=Cipher.getInstance("BLOWFISH");
    cipher.init(cipher.ENCRYPT_MODE,key);
    byte[] encrypt=cipher.doFinal(message.getBytes("UTF-8"));
    String enctext=Base64.getEncoder().encodeToString(encrypt);
    cipher.init(cipher.DECRYPT_MODE,key);
    byte[] decrypt=cipher.doFinal(Base64.getDecoder().decode(enctext));
    String dectext=new String(decrypt,"UTF-8");
    System.out.println("Original message: "+message);
    System.out.println("Encrypted: "+enctext);
    System.out.println("Decrypted: "+dectext);
    }
}
