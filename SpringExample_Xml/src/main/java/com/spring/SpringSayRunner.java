package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSayRunner {
    public static void main(String[] args) {
        ApplicationContext context =
                new FileSystemXmlApplicationContext("SpringExample_Xml\\src\\main\\resources\\spring-bean.xml");

//        ClassPathXmlApplicationContext context1 =
//                new ClassPathXmlApplicationContext("spring-bean.xml");
        Say obj1 = context.getBean("say", Say.class);
        obj1.say();



    }
}
