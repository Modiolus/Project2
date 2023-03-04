package myLessons.patterns.forTrain.facMethod;

public class VegetableMain {
    public static void main(String[] args) {
        VegetableFactory factory = new VegetableFactory();

       Vegetables potato = factory.getVegetables(VegetableType.POTATO);
       Vegetables tomato = factory.getVegetables(VegetableType.TOMATO);
       Vegetables cucumber = factory.getVegetables(VegetableType.CUCUMBER);
       potato.cut();
       tomato.cut();
       cucumber.cut();

    }
}
