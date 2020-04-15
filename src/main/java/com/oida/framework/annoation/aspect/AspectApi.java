package com.oida.framework.annoation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

import java.lang.reflect.Method;

public interface AspectApi {

    Object doHandlerAspect(ProceedingJoinPoint pjp, Method method)throws Throwable;
}
