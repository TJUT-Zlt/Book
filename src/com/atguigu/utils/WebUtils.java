package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * BeanUtils 工具类，它可以一次性的把所有请求的参数注入到 JavaBean 中。
 * BeanUtils 工具类，经常用于把 Map 中的值注入到 JavaBean 中，或者是对象属性值的拷贝操作。
 * BeanUtils 它不是 Jdk 的类。而是第三方的工具类。所以需要导包。
 * commons-beanutils-1.8.0.jar
 * commons-logging-1.1.1.jar
 *
 * @author abel
 * @create 2023-09-15 19:49
 */
public class WebUtils {
    /**
     * 把 Map 中的值注入到对应的 JavaBean 属性中。
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean(Map value,T bean){
        try {
//            System.out.println("注入之前"+bean);
            BeanUtils.populate(bean,value);
//            System.out.println("注入之后"+bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */

    public static int parseInt(String strInt,int defaultValue) {
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            //e.printStackTrace();
        }
        return defaultValue;
    }

}
