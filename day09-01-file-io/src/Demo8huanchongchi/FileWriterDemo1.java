package Demo8huanchongchi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;

public class FileWriterDemo1 {
    public static void main(String[] args) {
        try (
//                Writer wr = new FileWriter("day09-01-file-io\\src\\ioo444.txt")//覆盖
                Writer fw = new FileWriter("day09-01-file-io\\src\\ioo444.txt", true);
                //刷新缓冲区，将数据写出去
                BufferedWriter bw = new BufferedWriter(fw);
        ){

            //写一个字符出去
            bw.write('a');
            bw.write(98);
            bw.write('阿');
            bw.newLine();

            //写一个字符串出去
            bw.write("hello world");
            bw.write("阿翔");
            bw.newLine();

            //写一个字符数组出去
            char[] chars = "hello world".toCharArray();
            bw.write(chars);
            bw.newLine();

            //写一个字符数组的一部分出去
            bw.write(chars , 0 , 5);
            bw.newLine();

            bw.flush();//刷新缓冲区，将数据写出去

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
