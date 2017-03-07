/**
 *  自定义注解
 *  利用注解，从java类中直接生成SQL语句，创建Table。
 */
package com.ciaoshen.thinkinjava.chapter20.db;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLDecimal{
    public int value() default 0;
    public String name() default "";
    public Constraints constraints() default @Constraints;
}