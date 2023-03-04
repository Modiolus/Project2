package myLessons.patterns.AbstractFactory;

public interface DeviceFactory {
    Mouse getMouse();
    KeyBoard getKeyBoard();
    TouchPad getTouchPad();
}
