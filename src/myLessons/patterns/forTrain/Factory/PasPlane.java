package myLessons.patterns.forTrain.Factory;

public class PasPlane implements Plane{
    @Override
    public void fly() {
        System.out.println("Passengers plane can fly with passengers");
    }

    @Override
    public void engine() {
        System.out.println("Passengers plan has two engine");
    }
}
