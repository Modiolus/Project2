package myLessons.patterns.forTrain.Factory;

public class MainApp {
    public static void main(String[] args) {

        VehicleFactory factory = getVehicleByType("pas");
        Car c = factory.getCar();
        Ship s = factory.getShip();
        Plane p = factory.getPlane();

        c.wheel();
        c.canRide();

        s.length(250);
        s.height(50);

        p.fly();
        p.engine();

    }

    public static VehicleFactory getVehicleByType(String type) {
        if (type.equalsIgnoreCase("pas")) {
            return new PasFactory();
        } else if (type.equalsIgnoreCase("cargo")) {
            return new CargoFactory();
        } else throw new RuntimeException("This vehicle doesn't' exist");
    }
}
