package myLessons.patterns.forTrain.Factory;

public class CargoPlane implements Plane{
    @Override
    public void fly() {
        System.out.println("Cargo plane can fly with cargo ");
    }

    @Override
    public void engine() {
        System.out.println("Cargo plane has four engine");
    }
}
