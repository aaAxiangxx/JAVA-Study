
package demo.src.day03;
//
import java.util.Scanner;

public class test {
    // 测试方法
    // 主方法，程序的入口
    public static void main(String[] args) {
        // 调用test方法
        System.out.println("输入的和为；" + sum(10));
        System.out.println("============================");
        System.out.println("输入的奇数和为；" + sum1(10));
        System.out.println("============================");
        System.out.println("输入的奇数和为；" + sum2(10));
    }

    //=====================while=========================


    //=====================for=========================
    public static int sum2(int n){
        int sum1 = 0;
        for (int i = 1; i <= n; i+=2) {
            sum1 += i;
        }

        return sum1;
    }
    public static int sum1(int n){
        int sum1 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sum1 += i;
            }
        }
        return sum1;
    }

    public static int sum(int n){
        int sum = 0;
        for (int i = 1; i <= n; i++){
            sum += i;
        }
        return sum;
    }
    public static void test2(){
        for (int i = 0; i <= 10; i+=2){
            System.out.println(i);
        }
    }
    //=====================switch=========================
    public static void test(){
        System.out.println("请输入性别");
        System.out.println("男/女");

        Scanner sc = new Scanner(System.in);
        String aa = sc.next();

        switch(aa){
            case "男":
                System.out.println("输入的是男");
                break;
            case "女":
                System.out.println("输入的是女");
                break;
            default:
                System.out.println("什么都不是");
        }
    }
//=====================if=========================
    public static void test1(){
        boolean red = false; // 红灯
        boolean yellow = false;
        boolean green = true;
        if(red){
            System.out.println("stop");
        }else if(yellow){
            System.out.println("wait");
        }else if(green){
            System.out.println("go");
        }
    }
}
