package com.os.model;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MySelf {
    String name();
    int age();
    int height();
}
