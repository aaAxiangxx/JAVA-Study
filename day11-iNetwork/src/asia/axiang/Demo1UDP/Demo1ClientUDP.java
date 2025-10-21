package asia.axiang.Demo1UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Demo1ClientUDP {
    public static void main(String[] args) throws Exception {
        //完成udp通信多发多收
        System.out.println("==客户端启动==");
        //创建发送端对象
        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入:");
            String msg = sc.nextLine();

            //如果输入是exit则退出
            if ("exit".equals(msg)){
                System.out.println("==客户端退出==");
                socket.close();
                break;
            }

            byte[] bytes = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8080);

            //让发送端对象发送数据包的数据
            socket.send(packet);

            socket.close();
        }
    }
}
