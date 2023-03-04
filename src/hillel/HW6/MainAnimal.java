package hillel.HW6;

import javax.swing.*;

public class MainAnimal {
    public static void main(String[] args) {

        Wolf wolf = new Wolf();
        wolf.setId(1);
        wolf.setAge((byte) 5);
        wolf.setWeight(70);
        wolf.setColor("Gray");
        wolf.sayHello();
        //wolf.voice();
        System.out.println(wolf.toString());
        System.out.println("==================================");

        Dog dog = new Dog();
        dog.setId(2);
        dog.setAge((byte) 4);
        dog.setWeight(10);
        dog.setColor("Black");
        dog.setName("Bim");
        dog.sayHello();
        dog.sayWoof();
        // dog.isVaccinated();
        System.out.println(dog.toString());
        System.out.println("=================================");

        Cat cat = new Cat();
        cat.setId(3);
        cat.setAge((byte) 4.5);
        cat.setWeight(3.5);
        cat.setColor("white");
        cat.setName("Barsik");
        cat.sayHello();
        cat.sayMeow();
        System.out.println(cat.toString());
        System.out.println("==================================");

        Lion lion = new Lion();
        lion.setId(4);
        lion.setAge((byte) 8);
        lion.setWeight(80);
        lion.setColor("Yellow");
        lion.sayHello();
        System.out.println(lion.toString());
        System.out.println("===================================");

        Crocodile crocodile = new Crocodile();
        crocodile.setId(5);
        crocodile.setAge((byte) 9);
        crocodile.setWeight(100);
        crocodile.setColor("Green");
        crocodile.sayHello();
        System.out.println(crocodile.toString());
        System.out.println("=====================================");

        Giraffe giraffe = new Giraffe();
        giraffe.setId(6);
        giraffe.setAge((byte) 3);
        giraffe.setWeight(120);
        giraffe.setColor("Yellow-red");
        giraffe.sayHello();
        System.out.println("\n" + giraffe.toString());
        System.out.println("=====================================");

        Hamster hamster = new Hamster();
        hamster.setId(7);
        hamster.setAge((byte) 1.5);
        hamster.setWeight(0.7);
        hamster.setColor("Yeallow");
        hamster.setName("Tim");
        hamster.sayHello();
        System.out.println("\n" + hamster.toString());
        System.out.println("==================================");

        GuideDog guideDog = new GuideDog();
        guideDog.setId(8);
        guideDog.setAge((byte) 10);
        guideDog.setWeight(12);
        guideDog.setColor("Brown");
        guideDog.setName("Jack");
        guideDog.sayHello();
        guideDog.sayGuideDog();
        System.out.println(guideDog.toString());
        System.out.println("================================");

        SmallFish smallFish = new SmallFish();
        smallFish.setId(9);
        smallFish.setAge((byte) 2);
        smallFish.setWeight(0.1);
        smallFish.setColor("Gray");
        smallFish.sayHello();
        System.out.println(smallFish.toString());

    }

}
