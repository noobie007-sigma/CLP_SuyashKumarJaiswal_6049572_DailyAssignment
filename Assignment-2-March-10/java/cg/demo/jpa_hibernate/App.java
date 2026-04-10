package cg.demo.jpa_hibernate;

import cg.demo.jpa_hibernate.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Starting App !!!" );
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
        EntityManager em = emf.createEntityManager();
        //---adding Employee to the database---
//        Employee emp = new Employee();
//        emp.setId(101);
//        emp.setName("Aurindum");
//        emp.setSalary(500000);
//        emp.setDepartment("IT");
        
        em.getTransaction().begin();
        
//        em.persist(emp);
//        System.out.println("Employee has been Added Successfully");
        
        //---fetching Employee from the database---
//        Employee emp = em.find(Employee.class, 101);
//        System.out.println(emp);
        
        //---updating Employee in the database---
//        Employee emp = new Employee();
//        emp.setId(101);
//        emp.setName("Aurindum Bose");
//        emp.setSalary(550000);
//        emp.setDepartment("IT");
//        System.out.println(em.merge(emp));
        
        //---deleting Employee from the database---
//        Employee emp = em.find(Employee.class, 101);
//        em.remove(emp);
//        if(emp!=null) {
//			System.out.println("Employee has been Deleted Successfully");
//		}
//		else {
//			System.out.println("Employee not found!!!");
//		}
        
        
        em.getTransaction().commit();
        System.out.println("Ending App!!!");
        em.close();
        emf.close();
    }
}