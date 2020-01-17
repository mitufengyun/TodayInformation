package com.example.todayinformation.base;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * author: xpf
 * time: 2020/1/15 18:53
 * describe: 自定义注解，实现setContentView()的添加
 */
@Retention(RUNTIME)// 运行时起作用
@Target(TYPE) // 类、接口注解
public @interface ViewInject {
    int layoutId() default -1;
}
