package week04.homework;

import java.util.concurrent.Callable;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/16 0:00
 * @Version: 1.0
 */

public class Func1Thread  implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return sum();
    }

    private static int sum(){
        return fibo(36);
    }

    private static int fibo(int a){
        if (a < 2){
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }
}