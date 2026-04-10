package cg.demo.jpa_hibernate;


import java.util.Scanner;

//import cg.demo.jpahibernate.EmployeeDAO;
import cg.demo.jpa_hibernate.entities.Employee;

public class EmployeeUI {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        System.out.println("Starting App!");

        while (true) {

            System.out.println("\n---- EMPLOYEE MENU ----");
            System.out.println("1 Insert Employee");
            System.out.println("2 Get Employee By Id");
            System.out.println("3 Update Salary");
            System.out.println("4 Delete Employee");
            
            System.out.println("5 Exit");

            System.out.print("Enter choice : ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter id : ");
                    int id = sc.nextInt();

                    System.out.print("Enter dept : ");
                    String dept = sc.next();

                    System.out.print("Enter name : ");
                    String name = sc.next();

                    System.out.print("Enter phone : ");
                    long phone = sc.nextLong();

                    System.out.print("Enter salary : ");
                    double sal = sc.nextDouble();

                    Employee emp = new Employee(id, dept, name, phone, sal);

                    dao.insertEmployee(emp);

                    System.out.println("Employee inserted successfully");

                    break;

                case 2:

                    System.out.print("Enter id : ");
                    int eid = sc.nextInt();

                    Employee e = dao.getEmployeeById(eid);

                    if (e != null)
                        System.out.println(e);   // uses toString()
                    else
                        System.out.println("Employee not found");

                    break;

                case 3:

                    System.out.print("Enter id : ");
                    int uid = sc.nextInt();

                    System.out.print("Enter new salary : ");
                    double newsal = sc.nextDouble();

                    Employee updated = dao.updateSalary(uid, newsal);

                    if (updated != null)
                        System.out.println("Salary updated to: " + updated.getSalary());
                    else
                        System.out.println("Employee not found");

                    break;

                case 4:

                    System.out.print("Enter id : ");
                    int did = sc.nextInt();

                    Employee deleted = dao.deleteEmployee(did);

                    if (deleted != null)
                        System.out.println("Employee deleted successfully");
                    else
                        System.out.println("Employee not found");

                    break;

               

                case 5:

                    System.out.println("Program ended");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}