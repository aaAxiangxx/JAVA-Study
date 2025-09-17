package demo;

public class SilverCard extends Card{
    public SilverCard(String carid, String name, String phone, double money)  {
        super(carid, name, phone, money);
    }

    @Override
    public void consume(double money) {
        System.out.println("您当前消费：" + money);
        System.out.println("优惠后价格：" + money * 0.9 + "，您当前余额为：" + getMoney());
        System.out.println("已成功消费");
        if (getMoney() < money * 0.9){
            System.out.println("您的余额不足，请充值，当前余额为：" + getMoney());
            return;//干掉方法
        }
        //更新金卡的账户余额
        setMoney(getMoney() - money * 0.9);
        System.out.println("您当前余额为：" + getMoney());

    }

}
