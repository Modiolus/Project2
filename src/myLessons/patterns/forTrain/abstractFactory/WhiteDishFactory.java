package myLessons.patterns.forTrain.abstractFactory;

public class WhiteDishFactory implements DishFactory{
    @Override
    public Cups getCups() {
        return new WhiteCups();
    }

    @Override
    public Plates getPlates() {
        return new WhitePlates();
    }
}
