package Demo5copy;

import java.io.*;

public class copydemo1 {
    public static void main(String[] args) {
        try {
            copy("day09-01-file-io\\src\\io111.txt" , "day09-01-file-io\\src\\io333.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void copy(String src , String dest) throws Exception {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);

            //读取一个字节数组，写入一个字节数组
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                os.write(buffer , 0 , len);//读取多少，写入多少
            }
            System.out.println("复制完毕");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭流,资源释放
            try {
                if (is != null) is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                if (os != null) os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
