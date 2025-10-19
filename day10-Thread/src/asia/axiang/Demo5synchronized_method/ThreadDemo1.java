package asia.axiang.Demo5synchronized_method;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Account acc = new Account("IC", 100000);

        new DrawThread("小明", acc).start();
        new DrawThread("小红", acc).start();
    }
}
