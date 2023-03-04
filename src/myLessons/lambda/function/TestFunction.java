package myLessons.lambda.function;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;

public class TestFunction {
//    public static double averageMethod(ArrayList<Student3> students3List, Function<Double, Object> f, int capacity) {
////        double res = 0;
//        double res = students3List.stream().map(st -> f.apply(st.avdGrade)).count();
////        for(Student3 st: students3List){
////           res += st.avdGrade;
////        }
//        System.out.println(res);
//        return res / capacity;
//    }

    public static void main(String[] args) {
        Student3 st1 = new Student3("Ivan", 'm', 22, 3, 8.3);
        Student3 st2 = new Student3("Nikolay", 'm', 28, 2, 6.4);
        Student3 st3 = new Student3("Elena", 'f', 19, 1, 8.9);
        Student3 st4 = new Student3("Petr", 'm', 35, 4, 7);
        Student3 st5 = new Student3("Mariya", 'f', 23, 3, 9.1);

        ArrayList<Student3> students3 = new ArrayList<>();
        students3.add(st1);
        students3.add(st2);
        students3.add(st3);
        students3.add(st4);
        students3.add(st5);
//=========================================================================
        Function<Student3, Double> function = s-> (double)s.age;
//        function.apply(() -> stud.)

// TODO: 05.11.2022 моё творчество и попытка тренировки
//        System.out.println("MyMethod-->> " + averageMethod(students3, (Object s)->s., students3.size()));
//===================моё творчество и попытка тренировки==========================

        /*интерфейс Function<T, R> метод R apply(T t). Входным параментром в apply это Т - котрый идет на первом месте
         * в параметре Function, а возвращемый - это R - который в параметре Function на втором месте
         * используется когда на вход нужно принять один параметр, а вернуть другой*/

        Function<Student3, Double> f = st -> st.avdGrade;

        double res = avgSomth(students3, stud -> stud.avdGrade);// после стрелки stud.avdGrade это double т.е. это как-бы R
        // поэтому получается, что принимает Т, а возвращает R
        double res2 = avgSomth(students3, stud -> (double) stud.course); //stud-> (double)stud.course
        System.out.println(res);
        System.out.println(res2);
    }

    //=======================================================
    // TODO: 20.09.2021 попробовать использовать этот метод
    public static double avg(ArrayList<Student3> list, double d) {
        double res = 0;
        ListIterator<Student3> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
            res += d / list.size();
        }
        return res;
    }
    //=======================================================

    // метод подсчета среднего арифметического
    public static double avgSomth(ArrayList<Student3> list, Function<Student3, Double> f) {
        double result = 0;
        for (Student3 st : list) {
            result += f.apply(st);// т.е. принимает на вход Т, а возвращает R
        }
        result = result / list.size();
        return result;
    }
}
