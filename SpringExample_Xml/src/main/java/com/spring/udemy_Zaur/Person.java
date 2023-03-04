package com.spring.udemy_Zaur;

public class Person {
    private Pet pet;
    private String surname;
    private int age;

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

    public Person() { // пустой конструктор на случай, когда внедряем зависимость через сеттер. Его писать необязательно т.к. дефолтный - пустой

    }

    //    public Person(Pet pet) {
//        this.pet = pet;
//    }

    // ВАЖНО!! как Spring в <property name="pet" определяет какой конструктор взять?
// pet --> setPet //Spring в <property name="pet" берёт pet Ставит большую букву P и добавляет set
    public void setPet(Pet pet) {
        System.out.println("Create setPet");
        this.pet = pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet !");
        pet.say();

    }

}
