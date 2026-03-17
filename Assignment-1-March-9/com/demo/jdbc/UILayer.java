package com.demo.jdbc;

import java.sql.*;
import java.util.*;

public class UILayer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection conn = EmployeeDAO.getConnection();

            while (true) {

                System.out.println("\nChoose an operation:");
                System.out.println("1. Create Employee Table");
                System.out.println("2. View All Employees");
                System.out.println("3. View Employee By ID");
                System.out.println("4. Insert Employee");
                System.out.println("5. Update Employee");
                System.out.println("6. Delete Employee");
                System.out.println("7. Drop Table");
                System.out.println("8. Exit");

                System.out.print("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        EmployeeDAO.createTable(conn);
                        System.out.println("Employee table ensured.");
                        break;

                    case 2:

                        List<Employee> list = EmployeeDAO.readAll(conn);

                        if (list.isEmpty()) {
                            System.out.println("No employees found.");
                        } else {
                            for (Employee e : list) {
                                System.out.println(e);
                            }
                        }

                        break;

                    case 3:

                        System.out.print("Enter Employee ID: ");
                        int rid = sc.nextInt();

                        Employee emp = EmployeeDAO.readById(conn, rid);

                        if (emp == null)
                            System.out.println("Employee not found");
                        else
                            System.out.println(emp);

                        break;

                    case 4:

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        int salary = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Phone Number: ");
                        String phone = sc.nextLine();

                        Employee newEmp = new Employee(id, name, salary, dept, phone);

                        Employee inserted = EmployeeDAO.insert(conn, newEmp);

                        if (inserted != null)
                            System.out.println("Inserted: " + inserted);
                        else
                            System.out.println("Insertion failed");

                        break;

                    case 5:

                        System.out.print("Enter Employee ID to update: ");
                        int uid = sc.nextInt();

                        System.out.print("Enter new Salary: ");
                        int newSalary = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Department: ");
                        String newDept = sc.nextLine();

                        Employee updateEmp = new Employee(uid, "", newSalary, newDept, "0");

                        Employee updated = EmployeeDAO.update(conn, uid, updateEmp);

                        if (updated != null)
                            System.out.println("Updated: " + updated);
                        else
                            System.out.println("Employee not found");

                        break;

                    case 6:

                        System.out.print("Enter Employee ID to delete: ");
                        int did = sc.nextInt();

                        Employee deleted = EmployeeDAO.delete(conn, did);

                        if (deleted != null)
                            System.out.println("Deleted: " + deleted);
                        else
                            System.out.println("Employee not found");

                        break;

                    case 7:

                        EmployeeDAO.dropTable(conn);
                        System.out.println("Employee table dropped.");

                        break;

                    case 8:

                        conn.close();
                        System.out.println("Program terminated.");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


