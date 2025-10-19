package Demo9InputstreamReader;

import java.io.*;

public class InputStreamReaderDemo1 {
    public static void main(String[] args) {

        try (
                //先提取文件原始字节流
                InputStream is = new FileInputStream("day09-01-file-io\\src\\GBK.txt");
                //指定字符集把原始字符流转换成字符输入流
                Reader isr = new InputStreamReader(is, "GBK");
                //把字符输入流转换成字符缓冲流
                BufferedReader br = new BufferedReader(isr);
        ){
            //定义一个字符串变量用于记住每行数据
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
