package Demo10PrintStream;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintlnStreamDemo1 {
    public static void main(String[] args) {
        //打印流的使用
        try (
                //覆盖
//                PrintStream ps = new PrintStream("day09-01-file-io\\src\\PrintlnStreamDemo1.txt")
                //追加
                PrintStream ps = new PrintStream(new FileOutputStream("day09-01-file-io\\src\\PrintlnStreamDemo1.txt",true))
                ){
            ps.println("hello world");
            ps.println(100);
            ps.println('a');
            ps.println(true);
            ps.println('我');

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
