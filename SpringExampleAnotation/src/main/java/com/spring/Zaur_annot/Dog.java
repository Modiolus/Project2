package com.spring.Zaur_annot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@Scope("singleton") // определение скопа через аннотацию
//@Scope("prototype")
public class Dog implements Pet {
    public Dog() {
        System.out.println("Bean Dog is created....");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

//    @PostConstruct
//    public void init() {
//        System.out.println("Class Dog: init-method");
//    }
//    @PreDestroy
//    public void destroy(){
//        System.out.println("Class Dog: destroy-method");
//    }
}
