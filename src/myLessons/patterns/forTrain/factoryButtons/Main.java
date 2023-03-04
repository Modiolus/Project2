package myLessons.patterns.forTrain.factoryButtons;

public class Main {


    public static void main(String[] args) {
   Application app = configureApplication();
   app.paint();

    }
    private static Application configureApplication(){
        Application app;
        GUIFactory factory;

        String osName = System.getProperty("os.name").toLowerCase();
        if(osName.contains("mac")){
            factory = new MacOsFactory();
            app = new Application(factory);
        }else {
            factory = new WindowsFactory();
            app = new Application(factory);
        }
        return app;
    }
}
