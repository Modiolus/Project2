package com.spring.Zaur_annot;

import org.springframework.stereotype.Component;

//@Component("catBean") // В скобках пишется название id. Можно id не указывать в скобках. Тогда Spring
// создаст его автоматом по названию класса с маленькой буквы.
// Если класс называется с 2 больших букв(SQLClass или favoriteSong) то название id будет равно названию класса
public class Cat implements Pet {

    public Cat() {
        System.out.println("Bean Cat is created....");
    }

    @Override
    public void say() {
        System.out.println("Meow-meow");
    }
}
