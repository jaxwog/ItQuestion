package com.wyz.design.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
//子类继承，接口不起作用
@Inherited
@Documented
public @interface Description {
    String value() default "";
}
