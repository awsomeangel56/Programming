import java.math.BigInteger;
import java.security.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class secure {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        // ----------------- Diffie-Hellman -----------------
        System.out.print("Enter q: ");
        BigInteger q = sc.nextBigInteger();
        System.out.print("Enter a: ");
        BigInteger a = sc.nextBigInteger();
        System.out.print("Enter xa: ");
        BigInteger xa = sc.nextBigInteger();
        System.out.print("Enter xb: ");
        BigInteger xb = sc.nextBigInteger();

        BigInteger ya = a.modPow(xa, q);
        BigInteger yb = a.modPow(xb, q);

        System.out.println("Public key of A: " + ya);
        System.out.println("Public key of B: " + yb);

        BigInteger ka = yb.modPow(xa, q);
        BigInteger kb = ya.modPow(xb, q);

        System.out.println("Private key of A: " + ka);
        System.out.println("Private key of B: " + kb);

        sc.nextLine(); // consume newline

        // ----------------- Blowfish Encryption -----------------
        System.out.print("\nEnter message: ");
        String message = sc.nextLine();

        byte[] ke=ka.toByteArray();
        if(ke.length>16){
            ke=Arrays.copyOfRange(ke,0,16);
        }
        else if(ke.length<16){
            ke=Arrays.copyOf(ke,16);
        }

        SecretKeySpec key = new SecretKeySpec(ke, "BLOWFISH");
        Cipher cipher = Cipher.getInstance("BLOWFISH");

        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encrypt = cipher.doFinal(message.getBytes("UTF-8"));
        String enctext = Base64.getEncoder().encodeToString(encrypt);

        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(enctext));
        String dectext = new String(decrypt, "UTF-8");

        System.out.println("Original message: " + message);
        System.out.println("Encrypted: " + enctext);
        System.out.println("Decrypted: " + dectext);

        // ----------------- MD5 Hash -----------------
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] hash = md.digest(message.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : hash)
            sb.append(String.format("%02x", b));
        System.out.println("MD5 hash of message: " + sb.toString());
    }
}
