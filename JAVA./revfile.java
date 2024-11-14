import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class revfile {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter file name to read with .txt: ");
        String inf = s.nextLine(); 
        System.out.print("Enter file name to write with .txt: ");
        String onf = s.nextLine(); 
        try {
            FileReader fr=new FileReader(inf);
            StringBuilder content=new StringBuilder();
            int ch;
            while((ch=fr.read())!=-1){
                content.append((char)ch);
            }
            fr.close();
            String reversedcontent=content.reverse().toString();
            FileWriter fw=new FileWriter(onf);
            fw.write(reversedcontent);
            System.out.println("String reversed and written successfully !!");
            fw.close();
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}