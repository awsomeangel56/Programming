import java.util.*;
public class hill{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
    
        System.out.print("Enter 4 numbers for 2X2 key: ");
    int[][] key=new int[2][2];
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            key[i][j]=mod(sc.nextInt());
        }
    }
    sc.nextLine();

    System.out.println("Enter text");
    String text=sc.nextLine().toUpperCase().replaceAll("[^A-Z]","");
    while(text.length()%2!=0){
        text+="X";
    }
    String enc=encrypt(text,key);
    System.out.println("Encrypted: "+enc);
    int[][] inv=inverseKey(key);
    if(inv==null){
        System.out.println("Key is not invertible, decryption impossible !!");
    }
    else{
        System.out.println("Decrypted: "+decrypt(enc,inv));
    }
    }
    
    static String encrypt(String t,int[][] k){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<t.length();i+=2){
        int[] v={t.charAt(i)-'A',t.charAt(i+1)-'A'};
            for(int r=0;r<2;r++){
                int sum=0;
                for(int c=0;c<2;c++){
                    sum+=k[r][c]*v[c];
                }
                sb.append((char)(mod(sum)+'A'));
            }
        }
        return sb.toString();
    }
    static int mod(int x){
        x%=26;
        return x<0?x+26:x;
    }
    static String decrypt(String t,int[][] inv){
        return encrypt(t,inv);
    }
    static int[][] inverseKey(int[][] K){
        int det=mod(K[0][0]*K[1][1]-K[0][1]*K[1][0]);
        int invdet=modInverse(det);
        if(invdet==-1){
            return null;
        }
        int[][] adj=adjugate(K);
        int[][] inv=new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                inv[i][j]=mod(adj[i][j]*invdet);
            }
        }
        return inv;
    }
    static int[][] adjugate(int[][] M){
        int[][] adj=new int[2][2];
        adj[0][0]=mod(M[1][1]);
        adj[0][1]=mod(-M[0][1]);
        adj[1][0]=mod(-M[1][0]);
        adj[1][1]=mod(M[0][0]);
       return adj;
    }
    static int modInverse(int a){
        a=mod(a);
        for(int x=1;x<26;x++){
            if(mod(a*x)==1){
                return x;
            }
        }
        return -1;
    }
}



