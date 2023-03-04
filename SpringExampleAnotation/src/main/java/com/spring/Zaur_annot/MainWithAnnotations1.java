package com.spring.Zaur_annot;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWithAnnotations1 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("appContext.xml");// конфиг файл xml

//        Cat myCat = context.getBean("catBean", Cat.class); // catBean - это бин который указываем в калссе Cat в параметрах @Component
//        myCat.say();
        Person person = context.getBean("personBean", Person.class);
        person.callYourPet();

//        System.out.println(person.getSurname());
//        System.out.println(person.getAge());

        context.close();
    }
}
