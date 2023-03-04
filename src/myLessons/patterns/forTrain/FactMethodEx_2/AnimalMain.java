package myLessons.patterns.forTrain.FactMethodEx_2;

public class AnimalMain {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();

        Animal dog = animalFactory.getAnimal(AnimalTypes.DOG);
        Animal cat = animalFactory.getAnimal(AnimalTypes.CAT);
        Animal frog = animalFactory.getAnimal(AnimalTypes.FROG);

        dog.voiceAnimal();
        cat.voiceAnimal();
        frog.voiceAnimal();

    }
}
