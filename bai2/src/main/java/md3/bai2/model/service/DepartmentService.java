package md3.bai2.model.service;

import md3.bai2.model.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getDepartments();
    Department getDepartmentById(Integer departId);
    Department insertDepartment(Department depart);
    Department updateDepartment(Integer departId, Department depart);
    void deleteDepartment(Integer departId);

}
