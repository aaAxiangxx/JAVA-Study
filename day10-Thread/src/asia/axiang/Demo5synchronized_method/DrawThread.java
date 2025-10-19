package asia.axiang.Demo5synchronized_method;

public class DrawThread extends Thread{
    private Account acc;

    public DrawThread(String name , Account acc) {
        super(name);
        this.acc = acc;
    }

    @Override
    public void run(){
        acc.drawMoney(100000);
    }

}
