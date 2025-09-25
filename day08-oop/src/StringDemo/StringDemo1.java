package StringDemo;

import java.util.Scanner;

public class StringDemo1 {
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(s1);

        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String s4 = new String(chars);
        System.out.println(s4);

        byte[] bytes = {97, 98, 99, 100, 101};
        String s5 = new String(bytes);
        System.out.println(s5);




        //简易版登录
        String ok = "admin";
        System.out.println("请输入用户名：");
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        //字符串比较千万不要用 == 比较，==默认比较地址，字符串对象内容一样但地址不一样！！
        //判断字符串内容使用String提供的equals方法，只关心内容一样，就返回ture，不关心地址
        if (ok.equals( name)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }


        System.out.println("=================================");
        System.out.println("请输入手机号：");
        String phone = sc.next();
        System.out.println("系统显示以下手机号进入");
        String newPhone = phone.substring(0,3) + "****" + phone.substring(7);
        System.out.println(newPhone);
    }
}
