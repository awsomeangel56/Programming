import java.util.*;
public class hill3{
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
    System.out.print("Enter 9 letter key: ");
    String keyString=sc.nextLine().toUpperCase().replaceAll("[^A-Z]","");
    if(keyString.length()!=9){
        System.out.println("invalid key !!");
        return;
    }
    int[][] key=createKeyMatrix(keyString);        
    System.out.println("Enter text");
    String text=sc.nextLine().toUpperCase().replaceAll("[^A-Z]","");
    while(text.length()%3!=0){
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
    static int[][] createKeyMatrix(String key){
        int[][] keyMatrix=new int[3][3];
        for (int i=0;i<9;i++) {
            keyMatrix[i/3][i%3]=key.charAt(i)-'A';
        }
        return keyMatrix;
    }
    static String encrypt(String t,int[][] k){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<t.length();i+=3){
        int[] v={t.charAt(i)-'A',t.charAt(i+1)-'A',t.charAt(i+2)-'A'};
            for(int r=0;r<3;r++){
                int sum=0;
                for(int c=0;c<3;c++){
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
        int det=mod(K[0][0]*(K[1][1]*K[2][2]-K[1][2]*K[2][1])
                    -K[0][1]*(K[1][0]*K[2][2]-K[1][2]*K[2][0])
                    +K[0][2]*(K[1][0]*K[2][1]-K[1][1]*K[2][0]));
        int invdet=modInverse(det);
        if(invdet==-1){
            return null;
        }
        int[][] adj=adjugate(K);
        int[][] inv=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                inv[i][j]=mod(adj[i][j]*invdet);
            }
        }
        return inv;
    }
    static int[][] adjugate(int[][] M){
        int[][] A=new int[3][3];
        A[0][0]=(M[1][1]*M[2][2]-M[1][2]*M[2][1]);
        A[0][1]=-(M[1][0]*M[2][2]-M[1][2]*M[2][0]);
        A[0][2]=(M[1][0]*M[2][1]-M[1][1]*M[2][0]);
        A[1][0]=-(M[0][1]*M[2][2]-M[0][2]*M[2][1]);
        A[1][1]=(M[0][0]*M[2][2]-M[0][2]*M[2][0]);
        A[1][2]=-(M[0][0]*M[2][1]-M[0][1]*M[2][0]);
        A[2][0]=(M[0][1]*M[1][2]-M[0][2]*M[1][1]);
        A[2][1]=-(M[0][0]*M[1][2]-M[0][2]*M[1][0]);
        A[2][2]=(M[0][0]*M[1][1]-M[0][1]*M[1][0]);
        int[][] adj=new int[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                adj[i][j]=mod(A[j][i]);
            }
        }
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



