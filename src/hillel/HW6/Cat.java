package hillel.HW6;

public class Cat extends Pets {
    @Override
    public boolean isVaccinated() {
        return true;
    }

    void sayMeow() {
        System.out.println(". Meow");
    }
}
