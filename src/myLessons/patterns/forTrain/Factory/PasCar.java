package myLessons.patterns.forTrain.Factory;

public class PasCar implements Car {
    @Override
    public void wheel() {
        System.out.println("Passengers car has four wheel");
    }

    @Override
    public void canRide() {
        System.out.println("Passengers car can take passengers");

    }
}
