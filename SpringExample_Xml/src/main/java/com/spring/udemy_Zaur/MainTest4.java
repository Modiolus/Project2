package com.spring.udemy_Zaur;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-bean.xml");
//    Можно в параметрах писать через запятую несколько конфиг файлов
        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);

        myDog.say();
        yourDog.say();

        context.close();
    }
}
