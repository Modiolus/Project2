package myLessons.patterns.forTrain.absFactory;

public class VienFurnitureFactory implements FurnitureFactory{
    @Override
    public Chairs getChair() {
        return new VieneChair();
    }

    @Override
    public Couches getCouch() {
        return new VieneCouch();
    }
}
