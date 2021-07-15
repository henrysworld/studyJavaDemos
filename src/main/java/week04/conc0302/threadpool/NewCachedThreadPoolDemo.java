package week04.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 22:46
 * @Version: 1.0
 */
public class NewCachedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10000; i++) {
            final int no = i;


            exec(executorService, i);
        }

        executorService.shutdown();
        System.out.println("Main Thread End");
    }

    //这里该方法上了锁但是为什么还是不按照顺序执行？
    public synchronized static void exec(ExecutorService executorService, int no){
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("start: " + no);
                try {
                    Thread.sleep(1000L);
                    System.out.println("end: " + no);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        executorService.execute(runnable);
    }
}
