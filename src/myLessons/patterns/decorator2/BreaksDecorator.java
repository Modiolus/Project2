package myLessons.patterns.decorator2;

public class BreaksDecorator extends Decorator{



    public BreaksDecorator(PrinterInterface component) {
        super(component);
    }

    @Override
    public void print() {
        System.out.print("[");
        component.print();
        System.out.print("]");

    }
}
