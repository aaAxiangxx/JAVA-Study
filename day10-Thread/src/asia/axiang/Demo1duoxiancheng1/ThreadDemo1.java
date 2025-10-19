package asia.axiang.Demo1duoxiancheng1;

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t = new Mythread();

        t.start();

        for (int i = 0; i <5; i++) {
            System.out.println("主线程正在执行:" + i);
        }

    }

    private static class Mythread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i <5; i++) {
                System.out.println("子线程正在执行:" + i);
            }
        }
    }
}
