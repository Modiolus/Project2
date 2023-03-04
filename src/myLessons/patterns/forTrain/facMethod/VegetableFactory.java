package myLessons.patterns.forTrain.facMethod;

public class VegetableFactory {

    public Vegetables getVegetables(VegetableType type){
        Vegetables vegetable;
        switch (type){
            case POTATO:
                vegetable = new Potatoes();
                break;
            case TOMATO:
                vegetable = new Tomatoes();
                break;
            case CUCUMBER:
                vegetable = new Cucumber();
                break;
            default: throw new IllegalStateException("Unsupported vegetable...");

        }
        return vegetable;
    }
}
