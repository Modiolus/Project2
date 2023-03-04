package hillel.HW6;

public class Pets extends Animal implements Voice, Vaccinated, Trained {

    @Override
    public boolean isVaccinated() {
        return true;
    }

    @Override
    public boolean isTrained() {
        return true;
    }

    @Override
    public void sayHello() {
        System.out.print("Hello, my name is " + getName());
        if (isVaccinated()) {
            System.out.print(". I am vaccinated");
        }
    }

}
