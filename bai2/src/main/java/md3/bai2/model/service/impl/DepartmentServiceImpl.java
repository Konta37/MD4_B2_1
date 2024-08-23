package md3.bai2.model.service.impl;

import md3.bai2.model.entity.Department;
import md3.bai2.model.repository.DepartmentRepository;
import md3.bai2.model.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Integer departId) {
        return departmentRepository.findById(departId).orElseThrow(()->new NoSuchElementException("Khong co department nao co ma: "+departId));
    }

    @Override
    public Department insertDepartment(Department depart) {
        return departmentRepository.save(depart);
    }

    @Override
    public Department updateDepartment(Integer departId, Department depart) {
        departmentRepository.findById(departId).orElseThrow(()->new NoSuchElementException("Khong ton tain department : "+depart.getId()));
        depart.setId(departId);
        return departmentRepository.save(depart);
    }

    @Override
    public void deleteDepartment(Integer departId) {
        departmentRepository.findById(departId).orElseThrow(()->new NoSuchElementException("Khong ton tain department : "+departId));
        departmentRepository.deleteById(departId);
    }
}
