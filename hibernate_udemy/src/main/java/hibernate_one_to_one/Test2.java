package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        // try catch используется на случай, если вылетит исключение то factory точно закроется
        try {
//            Обратное действие:
//            внесение в таблицу Details и каскадное внесние в таблицу Employees
//            при этом объект в employees не будет ссылаться на соотв строку в details
//            для этого приходится все равно сетить сначала в Employee
//
            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Nikolay", "Ivanov", "HR", 850);
//
//            Detail detail = new Detail("New-York", "6542536", "nikolay@gmail.com");

//            employee.setEmpDetail(detail); // сначала сетим в Employee
//
//            detail.setEmployee(employee);
            session.beginTransaction(); // открытие транзакции

            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);
//          удаление строки из табл details без удаления работника из таблицы employees. Для этого сначала переписали каскад в классе Detail
//          Но вылетит исключение т.к. удаляя детали в details, объекту в employees не куда будет ссылаться. Поэтому нужно сначала разорвать связь
//          между табл employees и табл details. Для этого в форейн ки сетим null (код с троке 33)
            session.delete(detail); // удаление
//            System.out.println(detail.getEmployee());
//            session.save(detail);


            session.getTransaction().commit();  //закрытие транзакции и внесение данных в БД
//        session.getTransaction().rollback(); // откатывает назад то что было заведено в save
        } finally {
            factory.close();
        }


    }
}
