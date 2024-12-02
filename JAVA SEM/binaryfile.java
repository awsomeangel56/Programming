import java.io.*;
import java.util.*;
public class binaryfile{
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter filename to read with .bin: ");
        String inf=s.nextLine();
        System.out.print("Enter filename to write with .bin: ");
        String onf=s.nextLine();
        try{
        FileInputStream fr=new FileInputStream(inf);
        FileOutputStream fw=new FileOutputStream(onf);
        byte[] buffer=new byte[1024];
        int bytesread;
        while((bytesread=fr.read(buffer))!=-1){
            fw.write(buffer,0,bytesread);
        }
        fr.close();
        fw.close();
        }
        catch(Exception e){
            System.out.print(e);
        }
    }
}
