package myLessons.patterns.AbstractFactory;

public class RuKeyBoard implements KeyBoard{
    @Override
    public void print() {
        System.out.println("Печатаем строку ...");
    }

    @Override
    public void printLn() {
        System.out.println("Печатаем с переводом строки...");
    }
}
