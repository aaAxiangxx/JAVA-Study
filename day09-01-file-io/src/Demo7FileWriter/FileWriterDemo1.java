package Demo7FileWriter;

import java.io.FileWriter;
import java.io.Writer;

public class FileWriterDemo1 {
    public static void main(String[] args) {
        try (
//                Writer wr = new FileWriter("day09-01-file-io\\src\\ioo444.txt")//覆盖
                Writer wr = new FileWriter("day09-01-file-io\\src\\ioo444.txt", true)
        ){

            //写一个字符出去
            wr.write('a');
            wr.write(98);
            wr.write('阿');
            wr.write("\r\n");

            //写一个字符串出去
            wr.write("hello world");
            wr.write("阿翔");
            wr.write("\r\n");

            //写一个字符数组出去
            char[] chars = "hello world".toCharArray();
            wr.write(chars);
            wr.write("\r\n");

            //写一个字符数组的一部分出去
            wr.write(chars , 0 , 5);
            wr.write("\r\n");

            wr.flush();//刷新缓冲区，将数据写出去

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
