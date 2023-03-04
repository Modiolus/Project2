package hillel.arrayToList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator {
    public int[] array;
    private int index;

    public ArrayIterator(int index) {
        this.index = index;
    }

    public boolean fill() {
        int[] temp = new int[index];
        array = new int[temp.length * 2];
        return true;
    }

    @Override
    public boolean hasNext() {
        return index < array.length;
    }

    @Override
    public Integer next() {
        if (!hasNext())
            throw new NoSuchElementException();
        return array[index++];
    }

    public static void main(String[] args) {
        ArrayIterator arr = new ArrayIterator(10);
        arr.fill();
        while (arr.hasNext()) {
            System.out.println(arr.next());
        }
    }
}
