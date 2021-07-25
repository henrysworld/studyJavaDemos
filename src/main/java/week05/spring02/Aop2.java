package week05.spring02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Autor: HE CHEN
 * @Date: 2021/7/25 0:10
 * @Version: 1.0
 */
public class Aop2 {

    @Pointcut(value = "execution(* week05.spring02.Klass.dong(..))")
    public void point() {

    }

    @Before(value = "point()")
    public void before() {
        System.out.println("========>begin klass dong... //2");
    }

    @AfterReturning(value = "point()")
    public void after() {
        System.out.println("========>after klass dong... //4");
    }

    @Around("point()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("========>around begin klass dong //1");
        joinPoint.proceed();
        System.out.println("========>around after klass dong //3");
    }
}
