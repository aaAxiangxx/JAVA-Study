package asia.axiang.Demo1duoxiancheng1;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {
    public static void main(String[] args) {
        //创建一个Callable接口的实现类对象
        Callable<String> c1 = new MyCallable(100);
        //把Callable封装成一个真正的线程任务对象FutureTask对象
        FutureTask<String> f1 = new FutureTask<>(c1);
        //把FutureTask对象作为参数传递给Thread线程对象
        Thread t = new Thread(f1);
        //启动线程
        t.start();

        Callable<String> c2 = new MyCallable(200);
        FutureTask<String> f2 = new FutureTask<>(c2);
        Thread t2 = new Thread(f2);
        t2.start();

        //获取线程执行完毕后返回的结果
        try {
            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class MyCallable implements Callable<String> {
    //传入参数
    private int a;

    public MyCallable(int a) {
        this.a = a;
    }

    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= a; i++) {
            sum += i;
        }
        return "子线程执行完毕，1-" + a + "结果是：" + sum;
    }
}
