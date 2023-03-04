package myLessons.patterns.AbstractFactory;

import myLessons.patterns.AbstractFactory.KeyBoard;

public class EnKeyBoard implements KeyBoard {
    @Override
    public void print() {
        System.out.println("Print string ...");
    }

    @Override
    public void printLn() {
        System.out.println("Print string in a new line...");
    }
}
