package week04.conc0302.atomic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/16 0:06
 * @Version: 1.0
 */
public class SyncCount {
    private int num = 0;

    private Lock lock = new ReentrantLock(true);
    public int add(){
        try {
            lock.lock();
            return num++;
        } finally {
            lock.unlock();
        }
    }


    public int getNum(){
        return num;
    }
}
