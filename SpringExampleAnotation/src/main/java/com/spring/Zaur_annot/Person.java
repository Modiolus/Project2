package com.spring.Zaur_annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("personBean") // В скобках пишется название id. Можно id не указывать в скобках. Тогда Spring
// создаст его автоматом по названию класса с маленькой буквы.
// Если класс называется с 2 больших букв(SQLClass или favoriteSong) то название id будет равно названию класса
public class Person {
    //    @Autowired // точно также эту аннотацию можно использовать на поле, как здесь
//    @Qualifier("catBean")  // пишем над полем под @Autowired
    private Pet pet;
    @Value("${person.surname}")
    // сетим значения из пропертис файла(обязательно в xml файле прописываем адрес пропертиес)
    private String surname;
    @Value("${person.age}") // сетим значения из пропертис файла
    private int age;

    public Person() {
        System.out.println("Bean Person is created....");

    }

//    @Autowired  // для конструктора
//    // внедряет зависимость через конструктор. Ищет класс с @Component и в аргументы внедряет соотв объект
//    // если констурктор один, то эту аннотацию можно не писать. Спринг сам поймет какой выбрать конструктор!!!
//    public Person(Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }

    public Person(Pet pet) {
        System.out.println("Person bean is created");
        this.pet = pet;
    }

//    @Autowired
//    public Person(@Qualifier("catBean") Pet pet) { // Если @Qualifier используется в конструкторе, то писать его нужно
//        // перед параметром
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }

    //    @Autowired    // для сеттера
//    @Qualifier("dog") // пишем над сеттером. @Qualifier используется чтобы показать какой бин использовать
//    (указываем в скобках), если таких подходящих бинов несколько(несколько @Component)
//    public void setPet(Pet pet) {
//        System.out.println("Create setPet");
//        this.pet = pet;
//    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet !");
        pet.say();

    }

}
