package edu.whu;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface initMethod {
    String[] value() default {"20","计算机科学与技术","男"};
}
