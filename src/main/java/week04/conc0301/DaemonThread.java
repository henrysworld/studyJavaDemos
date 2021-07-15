package week04.conc0301;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/13 23:40
 * @Version: 1.0
 */
public class DaemonThread {
    public static void main(String[] args) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runnable task = () ->{
            Thread t = Thread.currentThread();
            System.out.println("当前线程：" + t.getName());
        };

        Thread thread = new Thread(task);
        thread.setName("test-Thread-1");
        thread.setDaemon(true);
        thread.start();

        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
