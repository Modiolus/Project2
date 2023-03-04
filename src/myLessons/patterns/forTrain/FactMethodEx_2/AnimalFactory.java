package myLessons.patterns.forTrain.FactMethodEx_2;

public class AnimalFactory {

    Animal getAnimal(AnimalTypes type){
        Animal animal;
        switch (type){
            case DOG:
                animal = new AnimalDog();
                break;
            case CAT:
                animal = new AnimalCat();
                break;
            case FROG:
                animal = new AnimalFrog();
                break;
            default:
                throw new RuntimeException(type + " this animal don't exist ");
        }
        return animal;
    }
}
