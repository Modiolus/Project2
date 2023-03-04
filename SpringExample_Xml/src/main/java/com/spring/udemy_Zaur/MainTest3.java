package com.spring.udemy_Zaur;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest3 {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-bean.xml");
        //конфиг файлов может быть несколько поэтому в скобках их можно перечислить через запятую
        //   Pet pet = context.getBean("myPet", Pet.class);
        Person person = context.getBean("myPerson", Person.class);

        //  System.out.println(pet.say());

//      Pet pet = new Dog();

        //     Person person = new Person(pet);

        person.callYourPet();
        System.out.println("Surname: " + person.getSurname());
        System.out.println("Age: " + person.getAge());
        System.out.println("=====================================");

        Dog myDog = context.getBean("myPet", Dog.class);
        Dog yourDog = context.getBean("myPet", Dog.class);
        System.out.println("Переменные ссылаются на один и тот же объект? " + (myDog==yourDog));

        context.close();

    }
}
