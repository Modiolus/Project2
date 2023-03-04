package myLessons.patterns.AbstractFactory;

public class RuMouse implements Mouse{
    @Override
    public void click() {
        System.out.println("Клик мышью...");
    }

    @Override
    public void doubleClick() {
        System.out.println("Двойной клик мышью...");
    }

    @Override
    public void scroll(int dir) {
        if (dir > 0) {
            System.out.println("Скроллим вверх...");
        } else if (dir < 0) {
            System.out.println("Скроллим вниз...");
        } else System.out.println("Не скроллим...");
    }
}
