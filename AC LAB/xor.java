import java.util.*;

public class xor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String text = sc.nextLine();
        System.out.print("Enter XOR key (e.g. 0 or 127): ");
        int key = sc.nextInt();

        String encrypted = xorEncrypt(text, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = xorEncrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);
    }

    static String xorEncrypt(String input, int key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            result.append((char) (input.charAt(i) ^ key));
        }
        return result.toString();
    }
}
//import java.util.*;
class xorCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter key (e.g. 0 or 127): ");
        int key = sc.nextInt();
        String enc = "", dec = "";
        for(char c : text.toCharArray()) enc += (char)(c ^ key);
        for(char c : enc.toCharArray()) dec += (char)(c ^ key);
        System.out.println("Encrypted: " + enc + "\nDecrypted: " + dec);
    }
}
Enter text: HELLO
Enter key (e.g. 0 or 127): 127
Encrypted: 55*))
Decrypted: HELLO

//