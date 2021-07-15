package week04.conc0302.atomic;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/16 0:08
 * @Version: 1.0
 */
public class AtomicMain {
    public static void main(String[] args) {
//        final Count count = new Count();
        final SyncCount count = new SyncCount();
//        final AtomicCount count = new AtomicCount();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    count.add();
                }
            }).start();
        }

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("num=" + count.getNum());
    }
}
