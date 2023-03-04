package myLessons.patterns.forTrain.factoryButtons;

public class Application {
    private Button button;
    private CheckBox checkBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckbox();
    }
    public void paint(){
        button.paint();
        checkBox.paint();
    }
}
