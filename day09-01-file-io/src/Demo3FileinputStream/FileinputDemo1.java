package Demo3FileinputStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileinputDemo1 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("day09-01-file-io\\src\\io111.txt");

        int b;
        while ((b = is.read()) != -1){
            System.out.print((char)b);
        }

        is.close();
    }
}
