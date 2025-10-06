import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class AESServer {
    private static SecretKey aesKey;
    
    public static void main(String[] args) throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        aesKey = keyGen.generateKey();
        
        System.out.println("Server started on port 8080");
        ServerSocket serversoc= new ServerSocket(8080);
        Socket client = serversoc.accept();
        System.out.println("Client connected");
        
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        
        out.writeUTF(Base64.getEncoder().encodeToString(aesKey.getEncoded()));
        
        String enmsg = in.readUTF();
        String demsg = decrypt(enmsg);
        System.out.println("Received: " + demsg);
        
        String response = "Hello from server!";
        String enresp= encrypt(response);
        out.writeUTF(enresp);
        
        client.close();
        serversoc.close();
    }
    
    private static String encrypt(String text) throws Exception {
        Cipher c= Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] e= c.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(e);
    }
    
    private static String decrypt(String enText) throws Exception {
        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] d= c.doFinal(Base64.getDecoder().decode(enText));
        return new String(d);
    }
}