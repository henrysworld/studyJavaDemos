package week05.spring02;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/25 0:10
 * @Version: 1.0
 */
public class Aop1 {
    public void startTransaction() {
        System.out.println("  ====>begin ding...");
    }

    public void commitTransaction() {
        System.out.println("  ====>finish ding... ");
    }

    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("  ====>around begin ding... ");
        joinPoint.proceed();
        System.out.println("  ====>around finish ding... ");
    }
}
