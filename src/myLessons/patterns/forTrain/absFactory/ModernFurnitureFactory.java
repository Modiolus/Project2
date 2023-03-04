package myLessons.patterns.forTrain.absFactory;

public class ModernFurnitureFactory implements FurnitureFactory{

    @Override
    public Chairs getChair() {
        return new ModernChair();
    }

    @Override
    public Couches getCouch() {
        return new ModernCouch();
    }
}
