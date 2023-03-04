package myLessons.patterns.FactoryMethod_2;

import java.util.Random;

public class EatRandomDoughnut {
    public static void eatRandomDoughnut(DoughnutFactory factory) {
        Doughnut randomDoughnut = getRandomDoughnut(factory);
        randomDoughnut.eat();

    }

    public static Doughnut getRandomDoughnut(DoughnutFactory factory) {
        Random random = new Random();

        DoughnutTypes type = DoughnutTypes.values()[random.nextInt(DoughnutTypes.values().length)];

        return (factory.getDoughnut(type));

    }
}
