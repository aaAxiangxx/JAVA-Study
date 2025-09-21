package demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        JD[] jds = new JD[4];
        jds[0] = new TV("电视", true);
        jds[1] = new WachMachine("洗衣机", false);
        jds[2] = new Lamp("灯", true);
        jds[3] = new Air("空调", false);

        //创建系统智能体对象，控制设备开和关
        SmartHomeControl smartHomeControl = SmartHomeControl.getInstance();
        //smartHomeControl.control(jds[0]);
        //打印全部设备的开合关状态
        while (true) {
            smartHomeControl.printAllStatus(jds);
            System.out.println("请选择要控制的设备");
            Scanner sc = new Scanner(System.in);
            String command = sc.next();
            switch (command) {
                case "1":
                    smartHomeControl.control(jds[0]);
                    break;
                case "2":
                    smartHomeControl.control(jds[1]);
                    break;
                case "3":
                    smartHomeControl.control(jds[2]);
                    break;
                case "4":
                    smartHomeControl.control(jds[3]);
                    break;
                    case "5":
                        System.out.println("退出");
                        return;
                default:
                    System.out.println("输入错误");

            }
        }
    }
}
