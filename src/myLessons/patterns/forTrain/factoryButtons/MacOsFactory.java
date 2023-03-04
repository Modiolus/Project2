package myLessons.patterns.forTrain.factoryButtons;

public class MacOsFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacOsButton();
    }

    @Override
    public CheckBox createCheckbox() {
        return new MacOSCheckBox();
    }
}
