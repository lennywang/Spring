package com.atguigu.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * 切面类
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.atguigu.aop.MathCaculator.*(..))")
    public void pointCut()
    {}

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName()+"运行。。。@Before：参数列表是：{"+ Arrays.asList(args)+"}");
    }

    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint)
    {
        System.out.println(joinPoint.getSignature().getName()+"结束。。。@After");
    }

    @AfterReturning(value = "pointCut()",returning = "result")
    public void logReturn(JoinPoint joinPoint,Object result)
    {
        System.out.println(joinPoint.getSignature().getName()+"正常返回。。。@AfterReturning：运行结果：{"+result+"}");
    }

    @AfterThrowing(value = "pointCut()",throwing = "exception")
    public void logException(JoinPoint joinPoint,Exception exception)
    {
        System.out.println(joinPoint.getSignature().getName()+"异常。。。异常信息：{"+exception+"}");
    }


}
