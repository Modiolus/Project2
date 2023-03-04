package myLessons.copmarator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test3 {
    public static void main(String[] args) {

        List<Workers> list = new ArrayList<>();

        Workers workers1 = new Workers(12, "Ivan", "Sidorov", 6341);
        Workers workers2 = new Workers(23, "Petr", "Petrov", 2525);
        Workers workers3 = new Workers(7, "Ivan", "Egorov", 3245);


        list.add(workers1);
        list.add(workers2);
        list.add(workers3);
        /* если оставить в параметрах только list, то будет сортировка по методу compareTo интерфейса Comparable
         * а если добавить соответвтующий экземпляр(в котором идет реализация отдльным классом по оределенному критерию),
         * то будет использоваться метод compare() интерфейса Comparator
         * при этом если в одном из классов Comparator используется String или Integer то необходимо воспользоваться методом String compareTo
         * Comparator удобно использовать когда в методе нужно напистаь собственную сортировку*/
        //  Collections.sort(list, new salaryComparator());
        Collections.sort(list, new idComparator()); // обратная сортировка
        Collections.sort(list, (s, a) -> s.salary - a.salary);// сортировка с comparator черз лямбду
        System.out.println(list);
    }
}

class Workers implements Comparable<Workers> {
    int id;
    String name;
    String surname;
    int salary;

    public Workers(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Workers workers) {

        if (this.id == workers.id) {
            return 0;
        } else if (this.id < workers.id) {
            return -1;
        } else {
            return 1;
        }
//        return this.id - workers.id;
    }
}

class idComparator implements Comparator<Workers> {
    @Override
    public int compare(Workers work1, Workers work2) {
//        if (work1.id == work2.id) {
//            return 0;
//        } else if (work1.id < work2.id) {
//            return -1;
//        } else {
//            return 1;
//        }
//             return work1.id- work2.id;
        return work2.id - work1.id; // обратная сортировка
    }
}

class nameComparator implements Comparator<Workers> {

    @Override
    public int compare(Workers work1, Workers work2) {
        return work1.name.compareTo(work2.name);

    }
}

class salaryComparator implements Comparator<Workers> {

    @Override
    public int compare(Workers work1, Workers work2) {

        return work1.salary - work2.salary;
    }
}



