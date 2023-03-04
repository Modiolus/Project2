package myLessons.patterns.AbstractFactory;

import myLessons.patterns.AbstractFactory.TouchPad;

public class EnTouchPad implements TouchPad {
    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Move to " + s + " pixels ");
    }
}
