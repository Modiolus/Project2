package hillel.train;

import java.util.ArrayList;
import java.util.Comparator;

public class Train {
    public Train(String test) {

    }


    public static void main(String[] args) {
        ArrayList<Train> ex = new ArrayList<>();
        ex.add(new Train("test"));
        ex.add(new Train("test2"));



        ex.forEach(u-> System.out.println(u.toString()));

    }
}
