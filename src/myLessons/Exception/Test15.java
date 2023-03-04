package myLessons.Exception;

public class Test15 {
    /* в этом примере мы создали свои собственные исключения
    * PodvernutNoguException и SvelomishcuException*/
    void marafon(int temperaturaVozduxa, int tempBega) throws PodvernutNoguException {
        if (tempBega > 12) {
            throw new PodvernutNoguException("Temp bega bil slishkom visokiy: " + tempBega);
        }
        if (temperaturaVozduxa > 32) {
            throw new SvelomishcuException();
        }
        System.out.println("Vi probegali marafon");
    }

    public static void main(String[] args) {
        Test15 t = new Test15();
        try {
            t.marafon(20, 13);
        } catch (PodvernutNoguException e) {
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("V lubom sluchae vi poluchite gramotu");
        }
    }
}

class PodvernutNoguException extends Exception {
    PodvernutNoguException(String message) {
        super(message);
    }
}

class SvelomishcuException extends RuntimeException {
    SvelomishcuException(String message) {
        super(message);
    }

    SvelomishcuException() {

    }
}