package Demo3FileinputStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileinputDemo2 {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("day09-01-file-io\\src\\io111.txt");

        //定义一个字节数组用于每次读取字节
        byte[] buffer = new byte[3];
        //定义一个变量记住每次读取了多少字节
        int len;
        while ((len = is.read(buffer)) != -1){
            //把读取到的字节数组转换成字符串输出，读取多少倒出多少
            String str = new String(buffer , 0 , len);
            System.out.print(str);
        }
        is.close();
    }
}
