package week04.conc0302.lock;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/14 23:36
 * @Version: 1.0
 */
public class ReentrantLockDemo {
    public static void main(String[] args) {
        final Count count = new Count();

        for (int i = 0; i < 2; i++) {
            new Thread(){
                @Override
                public void run() {
                    count.get();
                }
            }.start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                count.put();
            }).start();
        }
    }
}
