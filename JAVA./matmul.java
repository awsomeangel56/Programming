import java.util.Scanner;

class matmul {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int a[][]=new int[20][20];
        int b[][]=new int[20][20];
        int c[][]=new int[20][20];
        System.out.print("Enter the order of matrices: ");
        int m=s.nextInt();
        int n=s.nextInt();
        System.out.println("Enter the elements of 1st matrix: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                a[i][j]=s.nextInt();
            }
        }
        System.out.println("Enter the elements of 2nd matrix: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                b[i][j]=s.nextInt();
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                c[i][j]=0;
                for(int k=0;k<n;k++){
                    c[i][j]+=a[i][k]*b[k][j];
                }
            }
        }
        System.out.println("Resultant matrix: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                System.out.print(c[i][j]+" ");
    }
                System.out.println();   
        }
    }
}        