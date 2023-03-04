package myLessons.patterns.forTrain.Factory;

public class CargoCar implements Car{
    @Override
    public void wheel() {
        System.out.println("Cargo car has eight wheel");
    }

    @Override
    public void canRide() {
        System.out.println("Cargo car can take cargo");
    }
}
