package Demo4FileoutputStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class fileoutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //创建文件字节输出流管道与目标文件接通
        //OutputStream os = new FileOutputStream("day09-01-file-io\\src\\io222.txt");//覆盖
        OutputStream os = new FileOutputStream("day09-01-file-io\\src\\io222.txt" , true);

        //写入数据
        os.write(97);
        os.write('b');
        os.write("\r\n".getBytes());

        //写一个字节数组出去
        byte[] bytes = "哇哇哇哇哇".getBytes();
        os.write(bytes);

        //写一个字节数组的一部分出去
        os.write(bytes , 0 , 3);

        os.close();//关闭管道
    }
}
