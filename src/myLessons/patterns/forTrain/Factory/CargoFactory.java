package myLessons.patterns.forTrain.Factory;

public class CargoFactory implements VehicleFactory{
    @Override
    public Car getCar() {
        return new CargoCar();
    }

    @Override
    public Ship getShip() {
        return new CargoShip();
    }

    @Override
    public Plane getPlane() {
        return new CargoPlane();
    }
}
