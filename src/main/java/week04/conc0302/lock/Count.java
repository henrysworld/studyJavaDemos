package week04.conc0302.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 23:35
 * @Version: 1.0
 */
public class Count {
    final ReentrantLock lock = new ReentrantLock();

    public void get(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " get begin");
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " get end");
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void put(){
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " put begin");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " put end");
        lock.unlock();
    }
}
