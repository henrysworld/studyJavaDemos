package week04.conc0301;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/13 23:55
 * @Version: 1.0
 */
public class Runner1 implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("进入Runner1运行状态----------" + i);
        }
    }
}
