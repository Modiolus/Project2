package myLessons.ioFiles.binaryStream.programmer1;

import java.io.Serializable;

public class Employee implements Serializable {
    /* класс обязательно должен имплментировать Serializable. Классы в библиотеках Java уже как праивло имплементируют Serializable
     * если у одного программиста будет отличаться версия класса Employee(поля) от версии этого класса другого программиста
     * т.е. други поля то при десериализации выйдет исключение с сообщением. что разные версии класса serialVersionUID(именно эта цифра формируеся компилятором).
     * Мы можем прописать самостотельно serialVersionUID и в сообщении увидим цифры сответвтсующие врсии файла
     * Т.е. самостоятельно ставим при сериализации 2 а при десериализации 1.
     * Лучше ставить самостотельно т.к. компилятор может сделать ошибку из-за того что очень чувствителен к изменению в полях класса*/
   static final long serialVersionUID = 2;
    // нужно имплеменировать Serializable т.к. иначе не получится записать файл
    // в предидущих примерах все работало потому что String и ArrayList уже имплементируют Serializable

    String name;
    String lastName;
    String department;

    int age;
    transient
    double salary;
    // !!! ВАЖНО - transient используется, если НЕ нужно передавать этот параметр(может информация конфиденциальная)
    // Этот параметр не будет сериализирован. transient - буквально означает, что это временный параметр.
    Car car;

    public Employee(
            String name,
            String lastName,
            String department,
            int age,
            double salary,
            Car car) {
        this.name = name;
        this.lastName = lastName;
        this.department = department;
        this.age = age;
        this.salary = salary;
        this.car = car;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", car=" + car +
                '}';
    }
}
