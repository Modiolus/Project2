package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // try catch используется на случай, если вылетит исключение то factory точно закроется
        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // открытие транзакции

//            Изменение значений в таблице объекта
//            Аналог SQL запроса UPDATE. В случае выбора строки по id - Сам запрос писать не надо.
//            Достаточно сеттера
//            Employee emp = session.get(Employee.class, 1);
//            emp.setSalary(1500);

//            в остальных случаях нужно писать запрос
//           !!! Если нам нужно обновить данные удовлетворяющие условиям то используем в конце executeUpdate()
            session.createQuery("update Employee set salary = 1000 " +
                    "where name = 'Aleksandr'")
                            .executeUpdate();

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
