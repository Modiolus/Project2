package com.spring.Zaur_annot;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainScope {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");

        Dog myDog = context.getBean("dog", Dog.class);
        myDog.say();
        Dog yourDog = context.getBean("dog", Dog.class);

        System.out.println("Переменные ссылаются на один и тот же объект?: " + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);
        context.close();


    }
}
