package asia.axiang.Demo4_synchronized;

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
