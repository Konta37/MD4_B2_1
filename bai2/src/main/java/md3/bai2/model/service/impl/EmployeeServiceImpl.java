package md3.bai2.model.service.impl;

import md3.bai2.model.entity.Employee;
import md3.bai2.model.repository.EmployeeRepository;
import md3.bai2.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getCategories() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer emId) {
        return employeeRepository.findById(emId).orElseThrow(()->new NoSuchElementException("Khong co employeement nao co ma: "+emId));
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Integer emId, Employee employee) {
        employeeRepository.findById(emId).orElseThrow(()->new NoSuchElementException("Khong ton tain employeement : "+employee.getEmployeeId()));
        employee.setEmployeeId(emId);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer emId) {
        employeeRepository.findById(emId).orElseThrow(()->new NoSuchElementException("Khong ton tain employeement : "+emId));
        employeeRepository.deleteById(emId);
    }
}
