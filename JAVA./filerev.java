import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class filerev {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter file name to read with .txt: ");
        String inf = s.nextLine(); 
        System.out.print("Enter file name to write with .txt: ");
        String onf = s.nextLine(); 

        try {
            FileReader fr = new FileReader(inf);
            StringBuilder content = new StringBuilder();
            int ch;
            while ((ch = fr.read()) != -1) {
                content.append((char) ch); 
            }
            fr.close();

            String reversedContent = content.reverse().toString();

            FileWriter fw = new FileWriter(onf);
            fw.write(reversedContent);
            fw.close();

            System.out.println("File has been copied and reversed successfully.");
        } catch (Exception e) {
            System.out.println("An error occurred while processing the file: " + e.getMessage());
        }
    }
}
