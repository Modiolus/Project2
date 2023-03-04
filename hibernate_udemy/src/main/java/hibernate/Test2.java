package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // try catch используется на случай, если вылетит исключение то factory точно закроется
        try {
            Session session = factory.getCurrentSession();

            Employee emp = new Employee("Oleg", "Sidorov"
                    , "HR", 700);
            session.beginTransaction(); // открытие транзакции

            session.save(emp); // здесь hibernate инсертит данные в БД
//            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
//        session.getTransaction().rollback(); // откатывает назад то что было заведено в save

//        Выше добавление работника. Ниже получение работника.
            int myId = emp.getId();
//            session = factory.getCurrentSession();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId); // получение объекта из базы по id
            System.out.println(employee);

            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }
}
