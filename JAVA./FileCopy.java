import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFile = "C:\\Users\\index\\OneDrive\\Documents\\bilal.txt"; // Specify the source file path
        String destinationFile = "C:\\Users\\index\\OneDrive\\Documents\\copy.txt"; // Specify the destination file path

        copyFile(sourceFile, destinationFile);
    }

    public static void copyFile(String sourceFile, String destinationFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }

            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred during file operations.");
            e.printStackTrace();
        }
    }
}
