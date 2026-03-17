package cg.demos.springcore_assignment1_5;

import java.util.List;


public interface IEmployeeService {

    List<Employee> fetchAll();

    Employee findById(int id);

    void insert(Employee emp);

    boolean update(Employee emp);

    boolean delete(int id);
}