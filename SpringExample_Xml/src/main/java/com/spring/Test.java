package com.spring;

public class Test {
    private Long time = System.nanoTime();

    void print(){
        System.out.println("class:Test, method:print()  >>>> " + time);
        System.out.println("HashCode: "+this.hashCode());

    }

    void init(){
        System.out.println("init method...");
    }

//    void destroy(){
//        System.out.println("destroy method...");
//    }
}
