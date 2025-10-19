package asia.axiang.Demo1duoxiancheng1;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r = new MyRunnable();

        Thread t = new Thread(r);

        t.start();

        for (int i = 0; i <5; i++) {
            System.out.println("主线程正在执行:" + i);
        }
    }

    private static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i <5; i++) {
                System.out.println("子线程正在执行:" + i);
            }
        }
    }
}
