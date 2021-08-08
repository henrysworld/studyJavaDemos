package com.ch.code.database.aspect;

import com.ch.code.database.datasource.ManagementCenter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @Autor: HE CHEN
 * @Date: 2021/8/8 13:23
 * @Version: 1.0
 */
@Aspect
@Component
public class ReadAspect {

    @Autowired
    ManagementCenter managementCenter;

    @Pointcut("@annotation(com.ch.code.database.annotation.ReadAnnotation)")
    public void read(){};

    //获取参数，改变Datasource为slave节点

    public List<Map<String, Object>> setDatabaseSource(ProceedingJoinPoint point) throws Throwable {
        System.out.println("data source change......");
        Object[] argv = point.getArgs();
        argv[0] = managementCenter.getSlaveDataSource();
        return (List<Map<String, Object>>) point.proceed(argv);
    }
}
