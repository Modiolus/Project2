package com.spring.Zaur_annot;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest2 {
    public static void main(String[] args) {
//        вариант создания контекста через аннотации (класс MyConfig)
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);

        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

        System.out.println(person.getSurname());
        System.out.println(person.getAge());

//        Pet cat1 = context.getBean("catBean", Pet.class); // id в даной случае берётся из названия метода в MyConfig
//        Pet cat2 = context.getBean("catBean", Pet.class);
//
//        cat1.say();
//        cat2.say();

        context.close();


    }
}
