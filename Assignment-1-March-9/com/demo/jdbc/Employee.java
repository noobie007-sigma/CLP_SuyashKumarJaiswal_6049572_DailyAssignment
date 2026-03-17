package com.demo.jdbc;

public class Employee {

    private int id;
    private String name;
    private int salary;
    private String department;
    private String phoneNo;

    public Employee(int id, String name, int salary, String department, String phoneNo) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
        this.phoneNo = phoneNo;
    }

    public int getId() { return id; }

    public String getName() { return name; }

    public int getSalary() { return salary; }

    public String getDepartment() { return department; }

    public String getPhoneNo() { return phoneNo; }

    public void setSalary(int salary) { this.salary = salary; }

    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return id + " | " + name + " | " + salary + " | " + department + " | " + phoneNo;
    }
}
