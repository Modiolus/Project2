package hillel.listHW9;

import java.util.Arrays;

public class CollectionEx {

    private String[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public CollectionEx() {
        this.elements = new String[DEFAULT_CAPACITY];
    }

    public String get(int index) {
        isIndexExist(index);
        return elements[index];

    }

    public int size() {
        return size;
    }

    public boolean add(String value) {

        if (size == elements.length) {
            elements = increaseCapacity();
        }

        elements[size] = value;

        size++;
        return true;
    }

    public boolean add(String value, int index) {
        isIndexExist(index);
        String[] temp = elements;
        elements = new String[temp.length + 1];

        elements[index] = value;
        System.arraycopy(temp, 0, elements, 0, index);
        System.arraycopy(temp, index, elements, index + 1, temp.length - index);
        size++;
        return true;

    }

    @Override
    public String toString() {
        String[] temp = new String[size];
        System.arraycopy(elements, 0, temp, 0, size);
        return Arrays.toString(temp);
    }


    public boolean delete(int index) {
        isIndexExist(index);
        String[] temp = elements;
        elements = new String[temp.length - 1];
        String value = temp[index];

        System.arraycopy(temp, 0, elements, 0, index);
        System.arraycopy(temp, index + 1, elements, index, temp.length - index - 1);

        size--;
        return true;
    }

    public boolean delete(String value) {
        int index = 0;
        String[] temp = elements;
        elements = new String[temp.length - 1];
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == value) {
                index = i;
                String buf = value;
            }
        }
        System.arraycopy(temp, 0, elements, 0, index);
        System.arraycopy(temp, index + 1, elements, index, temp.length - index - 1);

        size--;
        return true;

    }

    private String[] increaseCapacity() {
        String[] temp = new String[(elements.length * 2)];
        System.arraycopy(elements, 0, temp, 0, elements.length);

        return temp;
    }

    private int isIndexExist(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Element can`t be found! " + "Number of elements in array = " + size +
                    ". Total size of array = " + elements.length);

        }
        return index;
    }
}
