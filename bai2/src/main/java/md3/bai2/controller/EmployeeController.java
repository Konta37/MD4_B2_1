package md3.bai2.controller;

import jakarta.validation.Valid;
import md3.bai2.exception.CustomException;
import md3.bai2.model.dto.DataResponse;
import md3.bai2.model.dto.EmployeeDTO;
import md3.bai2.model.entity.Department;
import md3.bai2.model.entity.Employee;
import md3.bai2.model.service.DepartmentService;
import md3.bai2.model.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<DataResponse> getAllEmployees() {
        return new ResponseEntity<>(new DataResponse(employeeService.getCategories(), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<? extends DataResponse> addEmployee(@Valid @RequestBody EmployeeDTO employee) {
        Employee employee1 = new Employee();

        Department department = departmentService.getDepartmentById(employee.getDepartmentId());

        employee1.setPhone(employee.getPhone());
        employee1.setFullName(employee.getFullName());
        employee1.setStatus(employee.getStatus());
        employee1.setDepartment(department);

        return ResponseEntity.created(URI.create("/api/v1/employees")).body(
                new DataResponse(employeeService.insertEmployee(employee1), HttpStatus.CREATED)
        );
    }
}
