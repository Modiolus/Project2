package myLessons.patterns.decorator2;

public abstract class Decorator implements PrinterInterface{
    PrinterInterface component;

    public Decorator(PrinterInterface component) {
        this.component = component;
    }
}
