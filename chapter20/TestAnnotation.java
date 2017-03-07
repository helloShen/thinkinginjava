/**
 *  Just Test Annotation
 */
package com.ciaoshen.thinkinjava.chapter20;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation{
    public String value() default "Hello World!";
}