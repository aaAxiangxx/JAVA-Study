package Demo8huanchongchi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo1 {
    public static void main(String[] args) {
         try (
                 Reader fr= new FileReader("day09-01-file-io\\src\\io111.txt");
                 BufferedReader br = new BufferedReader(fr);
         ) {
             //定义一个字符数组，每次读多个字符
//             char[] chs = new char[3];
//             int len;//用于记录每次读多少字符
//             while ((len = fr.read(chs)) != -1){
//                 //每次读取多个字符，并把字符数组转换成字符串输出
//                 String str = new String(chs , 0 , len);
//                 System.out.print(str);
//             }

//             System.out.println(br.readLine());
//             System.out.println(br.readLine());//null

             //使用循环改进，来按照行读取数据
             String line;
             while ((line = br.readLine()) != null){
                 System.out.println(line);
             }

         }catch (Exception e){
             e.printStackTrace();
         }
    }
}
