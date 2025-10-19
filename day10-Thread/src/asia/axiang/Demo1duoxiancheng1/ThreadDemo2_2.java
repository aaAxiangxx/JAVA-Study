package asia.axiang.Demo1duoxiancheng1;

public class ThreadDemo2_2 {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    System.out.println("子线程1正在执行:" + i);
                }
            }
        };

        Thread t = new Thread(r);

        t.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <5; i++) {
                    System.out.println("子线程2正在执行:" + i);
                }
            }
        }).start();

        new Thread(() -> {
                for (int i = 0; i <5; i++) {
                    System.out.println("子线程3正在执行:" + i);
                }

        }).start();

        for (int i = 0; i <5; i++) {
            System.out.println("主线程正在执行:" + i);
        }
    }
}
