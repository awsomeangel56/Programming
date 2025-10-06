import java.util.*;
import java.security.*;

public class md5 {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Text :");
    String plain = sc.nextLine();
    MessageDigest m = MessageDigest.getInstance("MD5");
    byte[] digest = m.digest(plain.getBytes());
    System.out.println("MD5 ;" + Base64.getEncoder().encodeToString(digest));
    StringBuilder hex = new StringBuilder();
    for (byte b : digest) {
      String h = String.format("%02x", b);
      hex.append(h);
    }
    System.out.println("Hex :" + hex);
  }
}
