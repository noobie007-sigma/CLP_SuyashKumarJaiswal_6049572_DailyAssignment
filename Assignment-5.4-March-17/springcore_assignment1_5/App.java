package cg.demos.springcore_assignment1_5;

import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext ac =
                new AnnotationConfigApplicationContext(AppConfig.class);

        IEmployeeService service =
                ac.getBean(IEmployeeService.class);

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n1.Insert 2.FetchAll 3.FindById 4.Update 5.Delete 6.Exit");
            int ch = sc.nextInt();

            switch(ch) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    service.insert(new Employee(id, name, salary));
                    System.out.println("Inserted!");
                    break;

                case 2:
                    service.fetchAll().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    Employee emp = service.findById(id);
                    System.out.println(emp != null ? emp : "Not Found");
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter new Salary: ");
                    salary = sc.nextDouble();

                    boolean updated =
                            service.update(new Employee(id, name, salary));

                    System.out.println(updated ? "Updated!" : "Not Found");
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();

                    boolean deleted = service.delete(id);
                    System.out.println(deleted ? "Deleted!" : "Not Found");
                    break;

                case 6:
                    System.exit(0);
            }
            
        }
        
    }
}