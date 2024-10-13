import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;
public class FileWriteExample1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("eneter file name with .txt: ");
        String filePath = s.nextLine();
        String content = "This is a sample sentence written to the file.";
        try{
            FileWriter fileWriter = new FileWriter("C:\\Users\\index\\OneDrive\\Documents\\bilal.txt");
            fileWriter.write(content);
            System.out.println("Successfully wrote to the file.");
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
