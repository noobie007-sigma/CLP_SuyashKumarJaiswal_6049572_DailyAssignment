package cg.demos.springcore_assignment1_5;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repo;

    @Override
    public List<Employee> fetchAll() {
        return repo.fetchAll();
    }

    @Override
    public Employee findById(int id) {
        return repo.findById(id);
    }

    @Override
    public void insert(Employee emp) {
        repo.insert(emp);
    }

    @Override
    public boolean update(Employee emp) {
        return repo.update(emp);
    }

    @Override
    public boolean delete(int id) {
        return repo.delete(id);
    }
}