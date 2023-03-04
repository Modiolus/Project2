package myLessons.patterns.decorator;

public class Truck implements Car {
    Car car;

    public Truck(Car car) {
        this.car = car;
    }

    @Override
    public int getSpeed() {
        return this.car.getSpeed();
    }

    @Override
    public int getBaggageWeight() {
        return this.car.getBaggageWeight() + 1000;
    }
}
