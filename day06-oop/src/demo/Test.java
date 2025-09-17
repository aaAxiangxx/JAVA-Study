package demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //加油站支付小程序
        //1.创建卡片类，以便创建金卡或银卡对象，封装车主数据
        //2.定义一个卡片父类。Card，定义金卡和银卡的共同属性和方法。
        //3.定义一个金卡类，继承Card类,金卡必须重写消费方法（8折优惠）独有功能打印洗车票。
        //4.定义一个银卡类，继承Card类,银卡必须重写消费方法（9折优惠）
        //5.办一张金卡，创建金卡对象，交给一个独立的业务（支付机）：存款，消费
        //6.办一张银卡，创建银卡对象，交给一个独立的业务（支付机）：存款，消费
        GoldCard gc = new GoldCard("112233","张三","13131313131",2000);
        pay(gc);
        SilverCard sc = new SilverCard("22332233","李四","13131313131",2000);
        pay(sc);
    }
    //支付机，用一个方法来刷卡:可能接收金卡也可能接受银卡。
    public static void pay(Card c){
        System.out.println("欢迎使用xx支付，请输入金额：");
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        c.consume(money);
    }
}
