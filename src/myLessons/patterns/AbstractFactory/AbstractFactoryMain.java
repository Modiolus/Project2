package myLessons.patterns.AbstractFactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {

        DeviceFactory factory = getDeviceFactoryByCountryCode("ru");

        Mouse m = factory.getMouse();
        KeyBoard k = factory.getKeyBoard();
        TouchPad t = factory.getTouchPad();

        m.click();
        m.doubleClick();
        m.scroll(5);

        k.print();
        k.printLn();

        t.track(4, 7);

    }

    private static DeviceFactory
    getDeviceFactoryByCountryCode(String lang) {
        if (lang.equalsIgnoreCase("ru")) {
            return new RuDeviceFactory();
        } else if (lang.equalsIgnoreCase("en")) {
            return new EnDeviceFactory();
        } else throw new RuntimeException("Unsupported country code...");
    }
}
