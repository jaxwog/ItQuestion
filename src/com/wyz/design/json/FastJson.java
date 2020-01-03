package com.wyz.design.json;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * com.wyz.design.json
 * Created by jax on 2019/12/30 13:45
 * TODO:对象转换为json字符串互转
 */
public class FastJson {
    //对象转json字符串
    public static String toJson(Object object) {
        //JSON载体
        StringBuffer jsonBuffer = new StringBuffer();
        //如果是List集合，按照集合处理，否则按照对象处理
        if (object instanceof List<?>) {
            jsonBuffer.append("[");
            List<?> list = (List<?>) object;
            for (int i = 0; i < list.size(); i++) {
                addObjectToJson(jsonBuffer, list.get(i));
                //jsonArarry添加  逗号分隔
                if (i < list.size() - 1) {
                    jsonBuffer.append(",");
                }
            }
        } else {
            addObjectToJson(jsonBuffer, object);
        }

        return jsonBuffer.toString();
    }

    //    解析单独的JSONObject类型   递归准备
    private static void addObjectToJson(StringBuffer jsonBuffer, Object o) {
        jsonBuffer.append("{");
        List<Field> fields = new ArrayList<>();
        getAllFields(o.getClass(), fields);

        for (int i = 0; i < fields.size(); i++) {
            //代表getMethod方法
            Method method = null;
            Field field = fields.get(i);
            //代表成员变量的值  张三
            Object fieldValue = null;
            String fieldName = field.getName();
            //fieldName  成员名称 name   a 97 A 65   getName
            String methodName = "get" + ((char) (fieldName.charAt(0) - 32) + fieldName.substring(1));

            try {
                //拿到Method(getName)对象
                method = o.getClass().getMethod(methodName);
            } catch (NoSuchMethodException e) {
                if (!fieldName.startsWith("is")) {
                    methodName = "is" + ((char) (fieldName.charAt(0) - 32) + fieldName.substring(1));
                    //拿到Method对象
                }
                try {
                    method = o.getClass().getMethod(methodName);
                } catch (NoSuchMethodException e1) {
                    replaceChar(i, fields, jsonBuffer);
                    continue;
                }
            }

            //拿到了成员变量对应的get方法
            if (method != null) {
                try {
                    //Integer 对象类型
                    fieldValue = method.invoke(o);
                } catch (Exception e) {
                    replaceChar(i, fields, jsonBuffer);
                    continue;
                }
            }
            //拿到了成员变量对应的值，判断值得类型
            if (fieldValue != null) {
                jsonBuffer.append("\"");
                jsonBuffer.append(fieldName);
                jsonBuffer.append("\":");
                if (fieldValue instanceof Integer
                        || fieldValue instanceof Double ||
                        fieldValue instanceof Long ||
                        fieldValue instanceof Boolean) {
                    jsonBuffer.append(fieldValue.toString());
                } else if (fieldValue instanceof String) {
                    jsonBuffer.append("\"");
                    jsonBuffer.append(fieldValue.toString());
                    jsonBuffer.append("\"");
                } else if (fieldValue instanceof List<?>) {
                    addListToBuffer(jsonBuffer, fieldValue);
                } else if (fieldValue instanceof Map) {
                    /**
                     * Map String String
                     * String Object
                     */
                } else {
                    addObjectToJson(jsonBuffer, fieldValue);
                }
                jsonBuffer.append(",");
            }

            if (i == fields.size() - 1 && jsonBuffer.charAt(jsonBuffer.length() - 1) == ',') {
                //删除最后一个逗号
                jsonBuffer.deleteCharAt(jsonBuffer.length() - 1);
            }
        }
        jsonBuffer.append("}");
    }

    private static void addListToBuffer(StringBuffer jsonBuffer, Object fieldValue) {
        //前面已经判断了fieldValue的类型
        List<?> list = (List<?>) fieldValue;
        jsonBuffer.append("[");
        for (int i = 0; i < list.size(); i++) {
            //遍历集合中的每一个元素
            addObjectToJson(jsonBuffer, list.get(i));
            if (i < list.size() - 1) {
                jsonBuffer.append(",");
            }
        }
        jsonBuffer.append("]");
    }

    public static void replaceChar(int i, List<Field> fields, StringBuffer jsonBuffer) {
        if (i == fields.size() - 1 && jsonBuffer.charAt(jsonBuffer.length() - 1) == ',') {
            //删除最后一个逗号
            jsonBuffer.deleteCharAt(jsonBuffer.length() - 1);
        }
    }

    /**
     * 获取当前Class  所有的成员变量 Field
     * 父类的Class  成员变量
     * Object 类型
     * final 修饰的成员变量
     * 递归方法
     */
    private static void getAllFields(Class<?> aClass, List<Field> fields) {
        if (fields == null) {
            fields = new ArrayList<>();
        }
        //排除Object类型
        if (aClass.getSuperclass() != null) {
            //拿到当前Class的所有成员变量的Field
            Field[] fieldsSelf = aClass.getDeclaredFields();
            for (Field field : fieldsSelf) {
                //排除final修饰的成员变量
                if (!Modifier.isFinal(field.getModifiers())) {
                    fields.add(field);
                }
            }
            getAllFields(aClass.getSuperclass(), fields);
        }

    }
}
