package hillel.lambdaEx;

public class ClassMain {
    public static void main(String[] args) {
        FunctionalInterfaceEx f = new FunctionalInterfaceEx() {     // анонимный класс
            @Override
            public double getResult(double a, double b) {
                return a + b;
            }
        };
        System.out.println(f.getResult(3, 4));
    }

}
