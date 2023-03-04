package com.spring.udemy_Zaur;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest2 {
    public static void main(String[] args) {
//   создание объекта через Application Context(это и есть контейнер)
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-bean.xml"); // в параметрах config file

        Pet pet = context.getBean("myPet", Pet.class); //"myPet" - id бина; Pet.class - тип бина. Эта строка формирует объект Dog
        Pet pet1 = context.getBean("myCat", Pet.class);

        System.out.println(pet.hashCode());
        System.out.println(pet1.hashCode());

        pet.say();
        pet1.say();

        context.close();
    }
}
