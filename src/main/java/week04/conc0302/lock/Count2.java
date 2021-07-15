package week04.conc0302.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 23:35
 * @Version: 1.0
 */
public class Count2 {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public void get(){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " get begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " get end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    public void put(){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " put begin");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " put end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}
