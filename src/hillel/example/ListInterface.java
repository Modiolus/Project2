package hillel.example;

import java.util.Collection;

public interface ListInterface {
    boolean add(String str);

    boolean addAll(String[] strArr);

    boolean addAll(Collection strColl);

    boolean delete(int index);

    boolean delete(String str);

    String get(int index);

    boolean contains(String str);

    boolean clear();

    int size();

    boolean trim();

    boolean compare(List coll);

}
