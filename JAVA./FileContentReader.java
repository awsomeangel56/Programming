import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileContentReader {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\index\\OneDrive\\Documents\\bilal.txt"; // Specify the file path here

        try (FileReader fr = new FileReader(filePath);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
