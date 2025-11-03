import java.security.*;
import java.util.*;
public class md5{
    public static void main(String[] args) throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter message: ");
        String message=sc.nextLine();
        MessageDigest md=MessageDigest.getInstance("MD5");
        byte[] hash=md.digest(message.getBytes("UTF-8"));
        System.out.println("MD5 hash: "+Base64.getEncoder().encodeToString(hash));
        StringBuilder result=new StringBuilder();
        for(byte b:hash){
            result.append(String.format("%02x",b));
        }
        System.out.print("hex: "+result.toString());
    }
}