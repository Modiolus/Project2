package com.spring;

import lombok.Getter;

public class Say {
    private long date;

    public Say() {
        this.date = System.currentTimeMillis() / 1000;
    }

    void init() {
        System.out.println(this.getClass().getName() + " >>> init");
    }

    void destroy() {
        System.out.println("destroy");
    }

    void say() {
        System.out.println("Hello .... " + date);
    }
}
