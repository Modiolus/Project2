package hillel.HW6;

public class Dog extends Pets {
    @Override
    public boolean isVaccinated() {
        return true;
    }

    void sayWoof() {

        System.out.println(". Woof");
    }
}
