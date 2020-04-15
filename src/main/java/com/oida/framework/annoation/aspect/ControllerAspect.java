package com.oida.framework.annoation.aspect;

import com.oida.framework.annoation.ValidationParam;
import com.oida.framework.utils.ComUtil;
import com.oida.framework.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

@Aspect
@Configuration
@Slf4j
public class ControllerAspect {

    @Pointcut("execution(* com.oida.framework.controller..*(..))  ")
    public void aspect() {
    }

    @Around("aspect()")
    public Object validationAspect(ProceedingJoinPoint pjp)throws Throwable{
        Method method =currentMethod(pjp,pjp.getSignature().getName());
        AspectApi aspectApi = new AspectApiImpl();
        if (!ComUtil.isEmpty(StringUtil.getMethodAnnotationOne(method, ValidationParam.class.getSimpleName()))){
            new ValidationParamAspect(aspectApi).doHandlerAspect(pjp,method);
        }
        return pjp.proceed(pjp.getArgs());
    }

    private Method currentMethod (ProceedingJoinPoint joinPoint , String methodName ) {
        Method[] methods      = joinPoint.getTarget().getClass().getMethods();
        Method   resultMethod = null;
        for ( Method method : methods ) {
            if ( method.getName().equals( methodName ) ) {
                resultMethod = method;
                break;
            }
        }
        return resultMethod;
    }


}
