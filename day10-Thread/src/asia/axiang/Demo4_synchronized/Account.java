package asia.axiang.Demo4_synchronized;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String cardID;
    private double money;

    public void drawMoney(double money) {

        String name = Thread.currentThread().getName();
        synchronized (this) {
            //判断余额是否足够
            if (this.money >= money) {
                System.out.println(name + "取钱成功，取钱金额：" + money);
                this.money -= money;
                System.out.println(name + "取钱成功，余额为：" + this.money);
            }else {
                System.out.println(name + "取钱失败，余额不足");
            }
        }
    }
}
