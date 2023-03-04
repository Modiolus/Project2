package myLessons.patterns.forTrain.absFactory;

public class MainApp {
    public static void main(String[] args) {

        FurnitureFactory factory = getFurnitureFactoryByStyle(FurnitureStyle.MODERN);
        Chairs chairs = factory.getChair();
        Couches couches = factory.getCouch();

        chairs.hasLegs();
        couches.hasCushion();

    }


    private static FurnitureFactory getFurnitureFactoryByStyle(FurnitureStyle style){
        FurnitureFactory factory;
        switch (style){
            case MODERN:
                factory = new ModernFurnitureFactory();
                break;
            case VIENE:
                factory = new VienFurnitureFactory();
                break;
            default: throw new IllegalStateException("Unsupported style...");
        }
        return factory;
    }
}
