package week04.homework;

import java.util.concurrent.*;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/15 23:59
 * @Version: 1.0
 */
public class HomeWork03 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //这里创建一个线程或线程池
        //异步执行下面方法

//        func1(start);
//        func2(start);
        func3(start);



//        int result = sum(); //这是得到的返回值
//
//
//        //确保拿到结果
//        System.out.println("异步计算结果为：" + result);
//
//        System.out.println("使用时间： " + (System.currentTimeMillis() - start));

        //退出main线程

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

    private static void func1(long start){

        try {
            Func1Thread func1Thread = new Func1Thread();
//
            FutureTask<Integer> futureTask = new FutureTask<>(func1Thread);

            new Thread(futureTask, "func1").start();
            int result = futureTask.get();
            //确保拿到结果
            System.out.println("异步计算结果为：" + result);

            System.out.println("使用时间： " + (System.currentTimeMillis() - start));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void func2(long start){

        Func2Thread t = new Func2Thread();
        new Thread(() ->{
            t.exec();
        }).start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int result = t.get();
        //确保拿到结果
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间： " + (System.currentTimeMillis() - start));
    }


    private static void func3(long start){

        ExecutorService executorService = Executors.newFixedThreadPool(16);
        Future<Integer> future = executorService.submit(() -> {
            return sum();
        });

        int result = 0;
        try {
            result = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //确保拿到结果
        System.out.println("异步计算结果为：" + result);

        System.out.println("使用时间： " + (System.currentTimeMillis() - start));

        executorService.shutdown();
    }
}
