package myLessons.patterns.decorator2;

public class PrintMain {
    public static void main(String[] args) {

        PrinterInterface printer = new QuotesDecorator(new BreaksDecorator(new Printer("Hello")));

        printer.print();
    }
}
