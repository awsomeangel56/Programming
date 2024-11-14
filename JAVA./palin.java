import java.util.*;
public class palin{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter the word: ");
        String p=s.nextLine().toLowerCase();
        int len=p.length();
        int c=0;
        for(int i=0;i<len/2;i++){
            if(p.charAt(i)!=p.charAt(len-i-1)){
                c++;
            }
        }
        if(c==0){
            System.out.print("Word is a pallindrome");
        }
        else{
            System.out.print("Not a pallindrome");
        }
    }
}