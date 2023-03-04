package com.projects.example.hibernate.base;

import com.projects.example.hibernate.base.entity.Address;
import com.projects.example.hibernate.base.entity.Sex;
import com.projects.example.hibernate.base.entity.User;
import com.projects.example.hibernate.base.entity.UserShort;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

//        User user1 = new User()
//                .setFirstName("Ivan")
//                .setLastName("Ivanov")
//                .setAge(37)
//                .setSex(Sex.M)
//                .setPasportNumber("XX234511")
//                .setPhone("380675644244");
//
//        User user2 = new User()
//                .setFirstName("Petr")
//                .setLastName("Petros")
//                .setAge(55)
//                .setSex(Sex.F)
//                .setPasportNumber("XX244522")
//                .setPhone("380675634217");
//
//        User user3 = new User()
//                .setFirstName("Stepan")
//                .setLastName("Stepanov")
//                .setAge(44)
//                .setSex(Sex.U)
//                .setPasportNumber("XX234423")
//                .setPhone("380675642234");
//
//
//        User user = new User()
//                .setLastName("Stepurko")
//                .setFirstName("Alex")
//                .setAge(37)
//                .setSex(Sex.M)
//                .setPasportNumber("XX234532")
//                .setPhone("380675644255");
//                .setAddress(new Address()
//                        .setZipCode("65000")
//                        .setCountry("Ukraine")
//                        .setCity("Odesa")
//                        .setStreet("Kanatnaya 22")
//                        .setFlat("2"));
//
//        session.save(user1);
//        session.save(user2);
//        session.save(user3);
//
//        session.save(user);

        session.getTransaction().commit(); // заносит данные в БД

//        Query q = session.createQuery("From User"); // запрос HQL
//
//        List<User> resultList = q.list();
//        System.out.println("num of users : " + resultList.size());
//        for (User usr : resultList) {
//            System.out.println(usr);
//        }
//
//        q = session.createQuery("From UserShort");
//
//        List<UserShort> rList = q.list(); // т.к. в UserShort есть только некоторые поля, то достанет из базы только эти поля
//        for (UserShort usr : rList) {
//            System.out.println(usr);
//        }

    }


}

