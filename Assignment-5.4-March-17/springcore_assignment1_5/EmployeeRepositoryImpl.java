package cg.demos.springcore_assignment1_5;

import java.util.*;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeRepositoryImpl implements IEmployeeRepository {

    private List<Employee> empList = new ArrayList<>();

    @Override
    public List<Employee> fetchAll() {
        return empList;
    }

    @Override
    public Employee findById(int id) {
        for(Employee e : empList) {
            if(e.getId() == id)
                return e;
        }
        return null;
    }

    @Override
    public void insert(Employee emp) {
        empList.add(emp);
    }

    @Override
    public boolean update(Employee emp) {
        for(int i = 0; i < empList.size(); i++) {
            if(empList.get(i).getId() == emp.getId()) {
                empList.set(i, emp);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return empList.removeIf(e -> e.getId() == id);
    }
}