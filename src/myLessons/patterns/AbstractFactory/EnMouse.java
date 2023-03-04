package myLessons.patterns.AbstractFactory;

import myLessons.patterns.AbstractFactory.Mouse;

public class EnMouse implements Mouse {
    @Override
    public void click() {
        System.out.println("Click by mouse...");
    }

    @Override
    public void doubleClick() {
        System.out.println("DoubleClick by mouse...");
    }

    @Override
    public void scroll(int dir) {
        if (dir > 0) {
            System.out.println("Scroll by mouse up...");
        } else if (dir < 0) {
            System.out.println("Scroll by mouse down...");
        } else System.out.println("Don't scroll...");
    }
}
