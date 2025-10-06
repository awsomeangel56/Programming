import java.io.*;
import java.net.Socket;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 8080);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                byte[] keyBytes = Base64.getDecoder().decode(in.readUTF());
        SecretKeySpec key = new SecretKeySpec(keyBytes, "AES");
        
        Cipher c= Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, key);
        String message = "Hello from client!";
        out.writeUTF(Base64.getEncoder().encodeToString(c.doFinal(message.getBytes())));
        System.out.println("Sent: " + message);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] dec = c.doFinal(Base64.getDecoder().decode(in.readUTF()));
        System.out.println("Received: " + new String(dec));
        
        socket.close();
    }
}