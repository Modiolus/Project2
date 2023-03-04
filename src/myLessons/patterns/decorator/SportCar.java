package myLessons.patterns.decorator;

public class SportCar implements Car{
    private Car car;

    public SportCar(Car car) {
        this.car = car;
    }

    @Override
    public int getSpeed() {
        return this.car.getSpeed() + 50;
    }

    @Override
    public int getBaggageWeight() {
        return this.car.getBaggageWeight();
    }
}
