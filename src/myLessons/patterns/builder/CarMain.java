package myLessons.patterns.builder;

import lombok.Builder;

public class CarMain {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder()
                .setEngine("v6")
                .setModel("Audi")
                .setCountDoor(4)
                .setPassengers(5)
                .build();

        Car car2 = new Car.CarBuilder()
                .setEngine("v8")
                .setModel("Mercedes")
                .setPassengers(4)
                .build();

        Car car3 = new Car.CarBuilder()
                .setEngine("4")
                .setModel("BMW")
                .setPassengers(4)
                .setCountDoor(3)
                .build();
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);


    }
}
