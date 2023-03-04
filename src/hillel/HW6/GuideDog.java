package hillel.HW6;

public class GuideDog extends Pets {

    @Override
    public boolean isTrained() {
        return true;
    }

    void sayGuideDog() {
        if (isTrained()) {
            System.out.println(". I can take you home");
        }
    }
}
