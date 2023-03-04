package com.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTestRunner {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("spring-bean.xml");
        Test test1 = context.getBean("test", Test.class);
        System.out.println("---------> 1");
        Thread.sleep(1000);

        Test test2 = context.getBean("test", Test.class);
        System.out.println("---------> 2");
        Thread.sleep(1000);

        Test test3 = context.getBean("test", Test.class);
        System.out.println("---------> 3");
        Thread.sleep(1000);

        test1.print();
        test2.print();
        test3.print();

        Object obj = context.getBean("test");
        if (obj instanceof Test) {
            ((Test) obj).print();
        }
       // context.close();
    }
}
