package com.ease.utils;

import java.lang.annotation.*;

@Documented //文档生成时，该注解将被包含在javadoc中，可去掉
@Target(ElementType.METHOD)//目标是方法
@Retention(RetentionPolicy.RUNTIME) //注解会在class中存在，运行时可通过反射获取
@Inherited
public @interface AccessAuthority {
    /**
     * 检查是否是卖家还是买家（注解的参数）
     */
    boolean isBuyer() default false;

    boolean isSeller() default false;
}
