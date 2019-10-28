package com.os.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class My {

    @MySelf(name="姜沅初",age=21,height=185)
    public static void main(String[] args) throws ClassNotFoundException {
        new My().getAnnotation();
    }

    private void getAnnotation() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.os.model.My"); //

        Method[] method = clazz.getMethods();
        for (Method m : method) {
            boolean ismEmpty = m.isAnnotationPresent(MySelf.class);
            if (ismEmpty) {
                Annotation[] aa = m.getAnnotations();
                for (Annotation a : aa) {
                    MySelf my = (MySelf) a;
                    System.out.println("My name is "+my.name()+",My age is "+my.age()+",My height is "+my.height()+"cm");
                }
            }
        }
    }

}
