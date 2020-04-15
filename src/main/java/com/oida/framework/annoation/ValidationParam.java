package com.oida.framework.annoation;


import java.lang.annotation.*;

/**
 * @author a6175
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidationParam {
    String value() default "";
}
