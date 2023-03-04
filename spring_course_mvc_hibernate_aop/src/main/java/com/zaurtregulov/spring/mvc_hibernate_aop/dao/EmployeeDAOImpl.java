package com.zaurtregulov.spring.mvc_hibernate_aop.dao;

import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//класс необходимый для получения данных из таблицы и передачи их в MyController
@Repository
// это специализированный @Component так же как и @Controller который тоже является компонентом и его будет искать Спринг чтобы ввести в контейнер
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired // показывает зависимость между sessionFactory и dataSource, который в свою очередь связывается с БД
    private SessionFactory sessionFactory;
    @Override
//    @Transactional // этой аннотацией спринг берёт на себя ответственность за открытие и закрытие транзакций - не нужно
    // применять session.beginTransaction() и session.getTransaction().commit()
    public List<Employee> getAllEmployees() {
        Session session = sessionFactory.getCurrentSession();

        List<Employee> allEmployees = session.createQuery("from Employee"
                , Employee.class).getResultList();

        return allEmployees;
    }
    @Override
    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

//        session.save(employee); // просто сохраняет объект в базе
        session.saveOrUpdate(employee); // если объекта нет в базе(id=0) то сохраняет нового, если есть(по наличию id) то обновляет существующего

    }

    @Override
    public Employee getEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);

        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee " +
                "where id =:employeeId");
//        :employeeId - вместо этого параметра будем подставлять соответствующий id
        query.setParameter("employeeId", id);
        query.executeUpdate();

    }

}
