import java.util.*;
public class caesar{
  public static String cencrypt(String text, int shift){
    StringBuilder result=new StringBuilder();
    shift=shift%26;
    for(char c:text.toCharArray()){
      if(Character.isUpperCase(c)){
      char ch=(char)((c-'A'+shift+26)%26+'A');
      result.append(ch);
    }
    else if(Character.isLowerCase(c)){
      char ch=(char)((c-'a'+shift+26)%26+'a');
      result.append(ch);
    }
    else{
      result.append(c);
    }
  }
  return result.toString();
  }
  public static String cdecrypt(String text, int shift){
    return cencrypt(text,-shift);
  }
public static void main(String[] args){
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter text: ");
  String text=sc.nextLine();
  System.out.println("Enter shift: ");
  int shift=sc.nextInt();
  String encrypted=cencrypt(text,shift);
  String decrypted=cdecrypt(encrypted,shift);
  System.out.println("\nEncrypted text: "+encrypted);
  System.out.println("\nDecrypted text: "+decrypted);
  sc.close();
  }
}
