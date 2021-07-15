package week04.conc0302.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 22:45
 * @Version: 1.0
 */
public class ExceptionDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Double> future = executorService.submit(() ->{
//            return 3.0;
            throw new RuntimeException("executorService.submit()");
        });

        try {
            double b = future.get();
            System.out.println("CH==" + b);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        executorService.shutdown();
        System.out.println("Main Thread End!!");
    }
}
