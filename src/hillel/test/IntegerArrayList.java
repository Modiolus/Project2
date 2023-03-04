package hillel.test;

import java.util.Arrays;

public class IntegerArrayList {
    private int [] elements;
//массив, для хранения чисел

    private int size;
//поле-счетчик, которое указывает на количество элементов в массиве

    private static final int DEFAULT_CAPACITY = 10;
//размер массива по умолчанию



//конструктор без параметров, который создает массив на 10 элементов, если размер не был указан

    public IntegerArrayList(){

        this.elements = new int[DEFAULT_CAPACITY];
    }


//создает массив указанной емкости

    public IntegerArrayList(int initialCapacity){
        if (initialCapacity >= 0){
            this.elements = new int[initialCapacity];
        }
        else {
            throw new IllegalStateException("Capacity can't be less than 0!");
        }
    }


//получает элемент по указанному индексу

    public int get(int index){
        isIndexExist(index);
//проверка корректности введенного индекса

        return elements[index];
    }


//возвращает количество элементов в списке

    public int size (){
        return size;
    }

//добавляем элемент в конец списка

    public boolean add(int value){
        if (size == elements.length){
//если в массиве места нет

            elements = increaseCapacity();
//вызываем метод, который отвечает за увеличение массива

        }
        elements[size] = value;
//записываем в конец списка новое значение

        size++;
//увеличиваем значение переменной размера списка

        return true;
    }

//дополнительный закрытый метод для увеличения емкости массива

    private int [] increaseCapacity(){
        int [] temp = new int[(elements.length * 2)];
//создаем новый массив большего размера

        System.arraycopy(elements, 0, temp, 0, elements.length);
//копируем в новый массив элементы из старого массива

        return temp;
    }

//устанавливает элемент на указанную позицию

    public int set(int value, int index){
       // isIndexExist(index);
        int temp = elements[index];
        elements[index] = value;
        return temp;
    }


//переопределил метод для красивого вывода списка на экран, иначе будут выводиться значения незаполненных ячеек [1, 10] вместо [1, 10, 0, 0...]

    @Override
    public String toString(){
        int [] temp = new int[size];
        System.arraycopy(elements, 0, temp, 0, size);
        return Arrays.toString(temp);
    }


//проверяем индексы, не выходят ли они за границы массива

    private int isIndexExist(int index){
        if (index >= size || index < 0){
            throw new IndexOutOfBoundsException("Element can't be found! "
                    + "Number of elements in array = " + size
                    + ". Total size of array = " + elements.length);
        }
        return index;
    }


//проверяем, есть ли элементы в списке

    public boolean isEmpty(){
        return (size == 0);
    }


//удаляем элемент по индексу

    public int remove (int index){
        isIndexExist(index);
//проверяем индекс

        int [] temp = elements;
//во временный массив заносим ссылку на текущий массив

        elements = new int [temp.length-1];
//полю elements присваиваем ссылку на новый массив размером меньше на 1

        int value = temp[index];
//сохраняем в доп. переменную значение удаляемого элемента

        System.arraycopy(temp, 0, elements, 0, index);
//копируем левую часть массива до указанного индекса

        System.arraycopy(temp, index + 1, elements, index, temp.length - index - 1);
//копируем правую часть массива после указанного индекса

        size--;
//уменьшаем значение переменной

        return value;
    }

    public static void main(String[] args) {
        IntegerArrayList ial = new IntegerArrayList();
        ial.add(2);
        ial.add(5);
        ial.add(10);
       // ial.remove(1);
        ial.set(21, 2);

        System.out.println(ial);

        System.out.println(ial.size);
    }
}
