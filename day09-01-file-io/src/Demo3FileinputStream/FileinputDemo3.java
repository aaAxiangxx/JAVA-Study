package Demo3FileinputStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileinputDemo3 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("day09-01-file-io\\src\\io111.txt");

        //一次性读取全部字节
        byte[] bytes = is.readAllBytes();

        String rs = new String(bytes);
        System.out.println(rs);

        is.close();
    }
}
