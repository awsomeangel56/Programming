import java.io.FileWriter;
import java.util.*;
public class Filewriter{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("Enter filename with .txt: ");
        String p=s.nextLine();
        System.out.println("Enter content to write to file: ");
        String cont=s.nextLine();
        try {
            FileWriter f=new FileWriter(p);
            f.write(cont);
            System.out.println("Successfully wrote to file !!");
            f.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}