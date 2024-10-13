import java.io.FileWriter;
import java.io.IOException;

public class FileWriteExample {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\index\\OneDrive\\Documents\\bilal.txt"; // Specify the file path here
        String sentence = "This is a sample sentence.";

        try {
            createFile(filePath);
            writeToFile(filePath, sentence);
            System.out.println("Sentence written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void createFile(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.close();
    }

    public static void writeToFile(String filePath, String sentence) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(sentence);
        writer.close();
    }
}
