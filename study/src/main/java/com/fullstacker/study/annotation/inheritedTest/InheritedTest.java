package com.fullstacker.study.annotation.inheritedTest;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 声明的此注解使用了Inherited元注解，表示此注解用在类上时，会被子类所继承
 * @author crazy
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedTest {
    
    String value();
}
