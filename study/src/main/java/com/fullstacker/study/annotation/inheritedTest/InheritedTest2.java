package com.fullstacker.study.annotation.inheritedTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedTest2 {

    String value();

}
