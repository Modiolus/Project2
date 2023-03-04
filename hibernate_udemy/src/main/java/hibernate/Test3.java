package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // try catch используется на случай, если вылетит исключение то factory точно закроется
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // открытие транзакции
//            Получение всех объектов из таблицы БД НЕ по id
//            В скобках указываем класс, а НЕ название таблицы
//            List<Employee> emps = session.createQuery("from Employee")
//                    .getResultList();

//           Получение объектов из таблицы БД с указанием условий
//            List<Employee> emps = session.createQuery("from Employee " +
//                            "where name ='Aleksandr'") // !!! name это название поля,а НЕ столбца
//                    .getResultList();

//          Если нам нужно вывести данные удовлетворяющие условиям то используем List и соответсвенно в конце getResultList()
            List<Employee> emps = session.createQuery("from Employee " +
                            "where name ='Zaur' and salary > 1000") //
                    .getResultList();

            for (Employee e : emps){
                System.out.println(e);
            }

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
