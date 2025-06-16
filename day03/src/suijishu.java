package demo.src.day03;

import java.util.Random;

public class suijishu {
    //随机数
    public static void main(String[] args) {
        guess();
    }
    public static void guess(){
        Random r = new Random();
        int num = (int) (Math.random() * 100) + 1;
        System.out.println("随机数是" + num);
    }
}
