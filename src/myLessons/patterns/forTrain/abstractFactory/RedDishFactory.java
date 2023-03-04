package myLessons.patterns.forTrain.abstractFactory;

public class RedDishFactory implements DishFactory{
    @Override
    public Cups getCups() {
        return new RedCups();
    }

    @Override
    public Plates getPlates() {
        return new RedPlates();
    }
}
