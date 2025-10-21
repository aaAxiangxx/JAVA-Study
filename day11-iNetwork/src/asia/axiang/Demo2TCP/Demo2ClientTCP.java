package asia.axiang.Demo2TCP;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Demo2ClientTCP {
    public static void main(String[] args) throws Exception {
        System.out.println("==客户端启动==");
        //常见socket管道对象，请求与服务器的Socket连接，可靠连接
        Socket socket = new Socket("127.0.0.1",8080);

        //从socket通信管道中得到一个字节输出流
        OutputStream os = socket.getOutputStream();

        //特殊数据流
        DataOutputStream dos = new DataOutputStream(os);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入数据：");
            String msg = sc.nextLine();
            if ("exit".equals(msg)){
                System.out.println("已退出");
                socket.close();
                break;
            }
            dos.writeUTF(msg);
            dos.flush();
        }


    }
}
