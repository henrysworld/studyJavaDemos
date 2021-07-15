package week04.conc0302.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 22:45
 * @Version: 1.0
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(16);
        try {
            String str = executorService.submit(() -> {
                return "I am a task, which submited by the so called laoda, and run by those anonymous workers";
            }).get();

            System.out.println("str = " + str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
