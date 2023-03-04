package hillel.forHW10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Train implements Iterator {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> iterator = arrayList.iterator();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}
