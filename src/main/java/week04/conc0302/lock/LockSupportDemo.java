package week04.conc0302.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/15 0:11
 * @Version: 1.0
 */
public class LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in " + getName());
                LockSupport.park();
                if (Thread.currentThread().isInterrupted()){
                    System.out.println("被中断了");
                }
                System.out.println("继续执行");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(1000L);
        t2.start();
        Thread.sleep(3000L);
        t1.interrupt();//中断？
        LockSupport.unpark(t2);//不知道什么意思

        t1.join();
        t2.join();
    }
}
