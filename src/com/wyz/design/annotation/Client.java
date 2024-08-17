package com.wyz.design.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Client {
    public static final String CLASS_NAME = "com.wyz.design.annotation.Child";
    public static final String METHOD_NAME = "eat";

    public static void main(String[] args) {
        try {
            //使用类加载器找到类
            Class<?> clazz = Class.forName(CLASS_NAME);

            Object object = clazz.newInstance();


            //类上是否存在想用到的注解
            boolean isPresent = clazz.isAnnotationPresent(Description.class);
            System.out.println(isPresent);
            //获取到类注解内容
            if (isPresent) {
                Description description = clazz.getAnnotation(Description.class);
                System.out.println(description.value());
            }

            //获取到方法上注解
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                boolean isMethod = method.isAnnotationPresent(Description.class);
                if (isMethod) {
                    Description description = method.getAnnotation(Description.class);
                    System.out.println(description.value());
                }

                if (method.getName().equals(METHOD_NAME)) {
                    method.invoke(object, 1, "tomato");
                    System.out.println("result type = " + method.getReturnType());
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    for (Class<?> parameterType : parameterTypes) {
                        System.out.println(parameterType);
                    }
                }

            }

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }

    }
}
