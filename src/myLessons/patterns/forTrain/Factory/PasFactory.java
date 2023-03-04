package myLessons.patterns.forTrain.Factory;

public class PasFactory implements VehicleFactory{
    @Override
    public Car getCar() {
        return new PasCar();
    }

    @Override
    public Ship getShip() {
        return new PasShip();
    }

    @Override
    public Plane getPlane() {
        return new PasPlane();
    }
}
