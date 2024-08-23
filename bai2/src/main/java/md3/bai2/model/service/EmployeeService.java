package md3.bai2.model.service;

import md3.bai2.model.entity.Employee;
import md3.bai2.model.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getCategories();
    Employee getEmployeeById(Integer emId);
    Employee insertEmployee(Employee employee);
    Employee updateEmployee(Integer emId, Employee employee);
    void deleteEmployee(Integer emId);
}
