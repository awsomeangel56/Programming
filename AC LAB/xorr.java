import java.util.*;
public class xorr{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter text: ");
        String text=sc.nextLine();
        System.out.println("Enter key (0 or 127): ");
        int key=sc.nextInt();
        sc.nextLine();
        String enc="", dec="";
        for(char c:text.toCharArray()){
            enc+=(char)(c^key);
        }
        for(char c:enc.toCharArray()){
            dec+=(char)(c^key);
        }
        System.out.println("Encrypted: "+enc);
        System.out.println("Decrypted: "+dec);
    }
}