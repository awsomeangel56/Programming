import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class Fileread{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.print("Enter file name with .txt: ");
        String p=s.next();
        try {
            FileReader f=new FileReader(p);
            int ch;
            while((ch=f.read())!=-1){
                
                System.out.print((char)ch);
            }
           
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found"); 
        }
        catch (IOException e) {
                System.out.println("Input output exception");
        }
        catch (Exception e) {
            System.out.println(e);
        }
       
    }
}


