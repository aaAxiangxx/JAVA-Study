package asia.axiang.Demo2TCP;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread{
    private Socket socket;
    public ServerReader(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            //获取输入流，读取客户端发送的消息
            InputStream is = socket.getInputStream();

            //把字节输入流包装成特殊输入流
            DataInputStream dis = new DataInputStream(is);

            //读取数据
            while (true) {
                String msg = dis.readUTF();
                System.out.println("收到的客户端msg:" + msg);
                //客户端的ip和端口
                String ip = socket.getInetAddress().getHostAddress();
                int port = socket.getPort();
                System.out.println("客户端的ip:" + ip + ",端口:" + port);
                System.out.println("---------------------------");
            }
        } catch (Exception e) {
            System.out.println("客户端已退出" + socket.getInetAddress().getHostAddress());
        }
    }

}
