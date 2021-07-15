package week04.conc0301;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 0:03
 * @Version: 1.0
 */
public class RunnerMain {

    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        Thread thread1 = new Thread(runner1);

        Runner2 runner2 = new Runner2();
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();

        thread2.interrupt();//i = true

        System.out.println(Thread.activeCount());

        Thread.currentThread().getThreadGroup().list();

        System.out.println(Thread.currentThread().getThreadGroup().getParent().activeGroupCount());

        Thread.currentThread().getThreadGroup().getParent().list();

    }
}
