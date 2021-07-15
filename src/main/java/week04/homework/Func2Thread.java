package week04.homework;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/16 0:01
 * @Version: 1.0
 */
public class Func2Thread extends Thread{
    int sum = 0;
    private Object lock = new Object();

    public void exec(){
        synchronized (lock){
            sum = sum();
        }
    }

    public int get(){
        return sum;
    }

    private synchronized int sum(){
        return fibo(36);
    }

    private synchronized int fibo(int a){
        if (a < 2){
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

}
