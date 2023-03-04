package myLessons.patterns.forTrain.abstractFactory;

public class DishMain {
    public static void main(String[] args) {

        DishFactory factory = dishFactoryByType(DishColorType.WHITE);

        Cups cup = factory.getCups();
        Plates plate = factory.getPlates();

        cup.hasCups();
        plate.hasPlates();


    }

    public static DishFactory dishFactoryByType(DishColorType type){
        DishFactory factory;
        switch (type){
            case RED:
                factory = new RedDishFactory();
                break;
            case WHITE:
                factory = new WhiteDishFactory();
                break;
            default: throw  new IllegalStateException("Unsupported dishes type...");
        }
        return factory;
    }
}
