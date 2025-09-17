package demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok技术可以实现为类自动添加getter setter方法，无参数构造器，toSring等方法
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String carid;
    private String name;
    private String phone;
    private double money;

    //预存金额
    public void deposit(double money) {
        this.money+=money;
    }
    //消费金额
    public void consume(double money) {
        this.money-=money;
    }
}
