package myLessons.patterns.forTrain.Factory;

public class CargoShip implements Ship{
    @Override
    public void length(int a) {
        System.out.println("Cargo ship length " + a);
    }

    @Override
    public void height(int b) {
        System.out.println("Cargo ship height " + b);
    }
}
