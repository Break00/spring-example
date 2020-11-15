package com.jason.lee.annotation.test;

import com.jason.lee.annotation.bean.Person;
import com.jason.lee.annotation.bean.SchoolFactoryBean;
import com.jason.lee.annotation.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author huanli9
 * @description
 * @date 2020/11/14 14:13
 */
public class Test {
    static ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);

    public static void main(String[] args) {
        String property = applicationContext.getEnvironment().getProperty("os.name");
        printBeans();
        // 默认单例
        Person bean = applicationContext.getBean("person", Person.class);
        System.out.println(bean);

        //获取工厂Bean创建的对象
        Object factoryBean = applicationContext.getBean("schoolFactoryBean");
        //获取工厂Bean本身
        //Object factoryBean = applicationContext.getBean("&schoolFactoryBean");

        System.out.println("factoryBean的类型：" + factoryBean.getClass());

    }

    private static void printBeans() {
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}