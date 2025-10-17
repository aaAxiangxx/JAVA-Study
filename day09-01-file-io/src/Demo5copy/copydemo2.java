package Demo5copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class copydemo2 {
    public static void main(String[] args) {
        try {
            copy("day09-01-file-io\\src\\io111.txt" , "day09-01-file-io\\src\\io333.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy(String src , String dest) throws Exception {
        try (
                //这里只能放置资源对象，用完后自动调用closr方法关闭！！
                InputStream is = new FileInputStream(src);
                 OutputStream os = new FileOutputStream(dest);
                ){
            //读取一个字节数组，写入一个字节数组
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);//读取多少，写入多少
            }
            System.out.println("复制完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
