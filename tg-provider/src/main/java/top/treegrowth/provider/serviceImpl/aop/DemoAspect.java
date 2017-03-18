package top.treegrowth.provider.serviceImpl.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author wusi
 * @version 2017/3/18 8:25.
 */
@Component
@Aspect
public class DemoAspect {

    private Demo demo;

    //aspect语法，切点可以作为参数传递进来，切点为Demo注解
    @Pointcut(value = "@annotation(demo)", argNames = "demo")
    public void pointCut(Demo demo) {
    }

    //前置通知，自动注入joinPoint,注意aspect语法
    @Before(value = "pointCut(demo)", argNames = "joinPoint, demo")
    public void before(JoinPoint joinPoint, Demo demo) {

    }
}
