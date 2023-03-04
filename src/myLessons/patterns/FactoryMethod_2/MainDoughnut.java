package myLessons.patterns.FactoryMethod_2;

public class MainDoughnut {
    public static void main(String[] args) {
        /*Паттерн фабричный метод позволяет создавать объекты не напрямую через new
        * а путём вызова фабричногоо метода(внутри которого всё равно объекты создаютя через new)*/
        DoughnutFactory doughnutFactory = new DoughnutFactory();

        Doughnut cherry = doughnutFactory.getDoughnut(DoughnutTypes.CHERRY);
        Doughnut chocolate = doughnutFactory.getDoughnut(DoughnutTypes.CHOCOLATE);
        Doughnut almond = doughnutFactory.getDoughnut(DoughnutTypes.ALMOND);

        cherry.eat();
        chocolate.eat();
        almond.eat();

        System.out.println("==============================================");
        EatRandomDoughnut.eatRandomDoughnut(doughnutFactory);


    }
}
