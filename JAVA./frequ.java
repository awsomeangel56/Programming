import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class frequ{
    public static void main(String[] args) {
        String p="bilal.txt";
        int c=0;
        int w=0;
        int l=0;
        try {
            BufferedReader reader=new BufferedReader(new FileReader(p));
            String line;
            while((line=reader.readLine())!=null){
                l++;
                c+=line.length();
                String[] words=line.split("\\s+");
                w+=words.length;
            }
            System.out.println("Number of Characters: "+c);
            System.out.println("Number of lines: "+l);
            System.out.println("Number of words: "+w);

            
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}