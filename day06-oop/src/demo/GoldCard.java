package demo;

public class GoldCard extends Card{
    public GoldCard(String carid, String name, String phone, double money) {
        super(carid, name, phone, money);
    }

    @Override
    public void consume(double money) {
        System.out.println("您当前消费：" + money);
        System.out.println("优惠后价格：" + money * 0.8);
        System.out.println("已成功消费");
        if (getMoney() < money * 0.8){
            System.out.println("您的余额不足，请充值，当前余额为：" + getMoney());
            return;//干掉方法
        }
        //更新金卡的账户余额
        setMoney(getMoney() - money * 0.8);
        System.out.println("您当前余额为：" + getMoney());
        //判断消费金额是否大于200，调用一个独有的功能，打印洗车票。
        if(money >= 200){
            printTicket();
        }else {
            System.out.println("您的消费金额不足200，无法打印洗车票");
        }
    }

    //打印洗车票
    public void printTicket(){
        System.out.println("您消费了，请打印洗车票");
    }
}
