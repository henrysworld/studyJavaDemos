package week04.conc0302.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/16 0:12
 * @Version: 1.0
 */
public class AtomicCount {
    private AtomicInteger num = new AtomicInteger();
    public int add(){
        return num.getAndIncrement();
    }

    public int getNum(){
        return num.get();
    }
}
