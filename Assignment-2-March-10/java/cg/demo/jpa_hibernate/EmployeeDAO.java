package cg.demo.jpa_hibernate;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import cg.demo.jpa_hibernate.entities.Employee;

public class EmployeeDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("JPA-PU");

    EntityManager em = emf.createEntityManager();

    // INSERT
    public Employee insertEmployee(Employee e) {

        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();

        return e;
    }

    // FETCH BY ID
    public Employee getEmployeeById(int id) {

        Employee e = em.find(Employee.class, id);
        return e;
    }

    // UPDATE SALARY
    public Employee updateSalary(int id, double newsal) {

        Employee e = em.find(Employee.class, id);

        if (e != null) {

            em.getTransaction().begin();
            e.setSalary(newsal);
            em.getTransaction().commit();
        }

        return e;
    }

    // DELETE
    public Employee deleteEmployee(int id) {

        Employee e = em.find(Employee.class, id);

        if (e != null) {

            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }

        return e;
    }

   
}