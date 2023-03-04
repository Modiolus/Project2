package hillel.arraytoListInterface;

public interface InterfaceCollection {

    boolean add(String value);

    boolean add(String value, int index);

    boolean delete(String value);

    boolean delete(int index);

    String get(int index);

    boolean contains(String value);

    boolean clear();

    int size();

}
