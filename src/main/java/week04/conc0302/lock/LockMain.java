package week04.conc0302.lock;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/15 0:06
 * @Version: 1.0
 */
public class LockMain {
    public static void main(String[] args) {
        Count3 count3 = new Count3();

        ThreadA threadA = new ThreadA(count3);
        threadA.setName("线程A");
        threadA.start();

        ThreadB threadB = new ThreadB(count3);
        threadB.setName("线程B");
        threadB.start();
    }
}
