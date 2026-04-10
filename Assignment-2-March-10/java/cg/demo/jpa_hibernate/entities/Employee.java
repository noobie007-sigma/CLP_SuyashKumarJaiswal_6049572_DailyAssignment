package cg.demo.jpa_hibernate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {

    @Id
    private int id;
    private String name;
    private double salary;
    private String dept;
    private long phoneno;

    // Default constructor (required by Hibernate)
    public Employee() {
    }

    // Parameterized constructor
    public Employee(int id, String dept, String name, long phoneno, double salary) {
        this.id = id;
        this.dept = dept;
        this.name = name;
        this.phoneno = phoneno;
        this.salary = salary;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getDept() { return dept; }
    public void setDept(String dept) { this.dept = dept; }

    public long getPhoneno() { return phoneno; }
    public void setPhoneno(long phoneno) { this.phoneno = phoneno; }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary +
               ", dept=" + dept + ", phoneno=" + phoneno + "]";
    }
}