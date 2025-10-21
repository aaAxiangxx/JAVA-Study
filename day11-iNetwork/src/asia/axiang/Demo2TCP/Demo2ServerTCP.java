package asia.axiang.Demo2TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Demo2ServerTCP {
    public static void main(String[] args) throws IOException {
        System.out.println("==服务端启动==");
        ServerSocket ss =new ServerSocket(8080);
        //调用accept方法，阻塞等待客户端连接
        while (true) {
            Socket socket = ss.accept();
            System.out.println("客户端已连接" + socket.getInetAddress().getHostAddress());

            new ServerReader(socket).start();
        }

    }
}
