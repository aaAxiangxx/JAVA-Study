package asia.axiang.Demo6lock;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String cardID;
    private double money;
    private final Lock lk = new ReentrantLock();

    public void drawMoney(double money) {
        String name = Thread.currentThread().getName();
        lk.lock();
        try {
            //判断余额是否足够
            if (this.money >= money) {
                System.out.println(name + "取钱成功，取钱金额：" + money);
                this.money -= money;
                System.out.println(name + "取钱成功，余额为：" + this.money);
            }else {
                System.out.println(name + "取钱失败，余额不足");
            }
        } finally {
            lk.unlock();//解锁
        }
    }
}
