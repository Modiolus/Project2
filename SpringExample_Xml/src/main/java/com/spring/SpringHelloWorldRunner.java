package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringHelloWorldRunner {
    public static void main(String[] args) throws InterruptedException {

        ApplicationContext context =
                new FileSystemXmlApplicationContext("SpringExample_Xml\\src\\main\\resources\\spring-bean.xml");
//       ==================================================================
//        Object obj1 = context.getBean("test");
//        Thread.sleep(1000);
//        Object obj2 = context.getBean("test");
//        Thread.sleep(1000);
//        Object obj3 = context.getBean("test");
//        Thread.sleep(1000);
//
//        ((Test)obj1).print();
//        ((Test)obj2).print();
//        ((Test)obj3).print();
        // более простое написание того, что выше
//        Test test1 = context.getBean("test", Test.class);
//        Test test2 = context.getBean("test", Test.class);
//
//        test1.print();
//        test2.print();
//============================================================================

        Teacher t = context.getBean("teacher", Teacher.class);

        Student s = context.getBean("student", Student.class);

        // TODO: 09.01.2022  при вызове метода start() пересетиваются
        //  значения вместо значений xml файла на значения в методе старт в User
//t.start();

//
//        System.out.println(t.toString());
//        System.out.println(s.toString());

SpringHelloWorld springHelloWorld = (SpringHelloWorld) context.getBean("springHelloWorld");
//           System.out.println(springHelloWorld);
//        SpringHelloWorld springHelloWorld = (SpringHelloWorld) context.getBean("springHelloWorld");
//        SpringHelloWorld springHelloWorld1 = (SpringHelloWorld) context.getBean("helloWorld");
//
        System.out.println(springHelloWorld.getStudent().toString());
        System.out.println(springHelloWorld.getUser().toString());

    }
}
