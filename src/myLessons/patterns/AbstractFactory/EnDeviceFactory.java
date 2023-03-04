package myLessons.patterns.AbstractFactory;

public class EnDeviceFactory implements DeviceFactory{
    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public KeyBoard getKeyBoard() {
        return new EnKeyBoard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}
