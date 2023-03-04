package myLessons.patterns.forTrain.Factory;

public class PasShip implements Ship{

    @Override
    public void length(int a) {
        System.out.println("Passengers ship length " + a);
    }

    @Override
    public void height(int b) {
        System.out.println("Passengers ship height " + b);
    }
}
