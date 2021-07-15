package week04.conc0302.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 22:46
 * @Version: 1.0
 */
public class NewFixedThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 100; i++) {
            final int no = i;
            executorService.execute(() ->{
                System.out.println("start:" + no);
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end:" + no);
            });
        }

        executorService.shutdown();
        System.out.println("Main Thread End!");
    }
}
