package cg.demos.springcore_assignments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cg.demos.springcore_assignments.beans.Employee;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    	ApplicationContext ac = new ClassPathXmlApplicationContext("configurations.xml");
    	Employee e1 = (Employee) ac.getBean("emp1");
    	
        System.out.println(e1);
    }
}
