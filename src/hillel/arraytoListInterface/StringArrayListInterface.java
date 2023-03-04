package hillel.arraytoListInterface;

import java.util.Arrays;
import java.util.Objects;

public class StringArrayListInterface implements InterfaceCollection {
    private String[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public StringArrayListInterface() {
        this.elements = new String[DEFAULT_CAPACITY];
    }

//    public StringArrayList(int initialCapacity) {
//        if (initialCapacity >= 0) {
//            this.elements = new String[initialCapacity];
//        } else {
//            throw new IllegalStateException("Capacity can`t be less then 0!");
//        }
//
//    }

    //  @Override
//    public String get(int index) {
//        return null;
//    }
    @Override
    public String get(int index) {
        isIndexExist(index);
        return elements[index];

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(String value) {

        if (size == elements.length) {
            elements = increaseCapacity();
        }

        elements[size] = value;

        size++;
        return true;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public boolean clear() {
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;

        }
        size = 0;

        return true;
    }

    @Override
    public boolean contains(String value) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringArrayListInterface that = (StringArrayListInterface) o;
        return size == that.size &&
                Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }

    private String[] increaseCapacity() {
        String[] temp = new String[(elements.length * 2)];
        System.arraycopy(elements, 0, temp, 0, elements.length);

        return temp;
    }

    private int capacity() { //мой собственный метод, чтобы просмотреть реальный объём массива в даный момент
        return elements.length;
    }

    private int isIndexExist(int index) {
        if (index >= size && index < 0) { // раньше было ||
            throw new IndexOutOfBoundsException("Element can`t be found! " + "Number of elements in array = " + size +
                    ". Total size of array = " + elements.length);

        }
        return index;
    }

    public static void main(String[] args) {
        StringArrayListInterface str = new StringArrayListInterface();
        str.add("Logitech", 0);
        System.out.println(str.get(0));
        System.out.println("Add value: ");

        str.add("Samsung");
        str.add("Apple");
        str.add("Philips");
        str.add("Acer");
        str.add("Asus");
        str.add("Dell");
        str.add("Xiaomi");
        str.add("HP");
        str.add("Lenovo");
        str.add("Seiko");

        System.out.println("Size: "+str.size);
        System.out.println("Old Capacity: " + str.capacity());

        str.add("Cola");
        str.add("Pepsi");
        str.add("Sprite");
        System.out.println(str);
        System.out.println("Size: "+str.size);
        System.out.println("New Capacity: " + str.capacity());

        StringArrayListInterface str2 = new StringArrayListInterface();
        System.out.println("Add value2: ");
        str2.add("Samsung");
        str2.add("Apple");
        str2.add("Philips");
        str2.add("Acer");
        str2.add("Asus");
        str2.add("Dell");
        str2.add("Xiaomi");
        str2.add("HP");
        str2.add("Lenovo");
        str2.add("Seiko");
        System.out.println(str2);

        System.out.println("Comparison: " + str.equals(str2));

        System.out.println("Contains? " + str.contains("Apple"));
        System.out.println("Contains? " + str.contains("Test"));

        System.out.println("Add value and index: ");
        str.add("Test", 1);
        System.out.println(str);


        System.out.println("Delete of value: ");
        str.delete("Apple");
        System.out.println(str);

        System.out.println("Delete of value on index: ");
        str.delete(4);
        System.out.println(str);


        System.out.println("Getting element of 6 index: " + str.get(6));
        System.out.println("Size of array: " + str.size());

        str.clear();
        System.out.println("Cleared " + str);


    }

}

