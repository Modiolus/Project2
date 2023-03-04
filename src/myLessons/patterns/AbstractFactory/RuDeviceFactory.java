package myLessons.patterns.AbstractFactory;

public class RuDeviceFactory implements DeviceFactory{
    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new RuKeyBoard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}
