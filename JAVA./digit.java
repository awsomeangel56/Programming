import java.util.*;
public class digit{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        String num[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
        String word[]=new String[100];
        int i=0,c=0;
        System.out.println("Enter the nummber: ");
        int n=s.nextInt();
        while(n>0){
            int d=n%10;
            c++;
            word[i]=num[d];
            i++;
            n/=10;
        }
        for(i=c-1;i>=0;i--){
            System.out.print(word[i]+" ");
        }


    }
}
       