package week04.conc0302.lock;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 23:34
 * @Version: 1.0
 */
public class ThreadB extends Thread{
    private Count3 count3;

    public ThreadB(Count3 count3) {
        this.count3 = count3;
    }

    @Override
    public void run() {
        count3.lockMethod();
    }
}
