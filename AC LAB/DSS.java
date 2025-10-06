import java.security.*;
import java.util.Base64;
import java.util.Scanner;

public class DigitalSignature {
    public static void main(String[] args) throws Exception {
        // Generate key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Input message
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message to be signed: ");
        String message = scanner.nextLine();

        // Create digital signature
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(privateKey);
        signature.update(message.getBytes());
        byte[] digitalSignature = signature.sign();

        System.out.println("Digital Signature: " + Base64.getEncoder().encodeToString(digitalSignature));

        // Verify digital signature
        signature.initVerify(publicKey);
        signature.update(message.getBytes());
        boolean isVerified = signature.verify(digitalSignature);

        System.out.println("Signature Verified: " + isVerified);
        scanner.close();
    }
}
