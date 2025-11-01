import java.util.*;
public class substitution{
    public static String SEncrypt(String text,String key){
        String standard="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result=new StringBuilder();
        for(char c:text.toCharArray()){
            if(Character.isLetter(c)){
                int index=standard.indexOf(c);
                result.append(key.charAt(index));
            }
            else
                result.append(c);    
        }
        return result.toString();
    }
    public static String SDecrypt(String text,String key){
        String standard="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder result=new StringBuilder();
        for(char c:text.toCharArray()){
            if(Character.isLetter(c)){
                int index=key.indexOf(c);
                result.append(standard.charAt(index));
            }
            else
                result.append(c);
        }
        return result.toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the text: ");
        String text=sc.nextLine().toUpperCase();
        System.out.println("Enter the 26 letter key [A-Z]: ");
        String key=sc.nextLine().toUpperCase();
        String enc=SEncrypt(text,key);
        System.out.println("Encrypted: "+enc);
        String dec=SDecrypt(enc,key);
        System.out.println("Decrypted: "+dec);
    }
}

