package md3.bai2.controller;

import md3.bai2.model.dto.DataResponse;
import md3.bai2.model.entity.Department;
import md3.bai2.model.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<DataResponse> getAllCategories(){
        return new ResponseEntity<>(new DataResponse(departmentService.getDepartments(), HttpStatus.OK),HttpStatus.OK);
    }

    @GetMapping("/{departId}")
    public ResponseEntity<DataResponse> getById(@PathVariable("departId")Integer cateId){
        return new ResponseEntity<>(new DataResponse(departmentService.getDepartmentById(cateId),HttpStatus.OK),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse> addDepartment(@RequestBody Department department){
        return new ResponseEntity<>(new DataResponse(departmentService.insertDepartment(department), HttpStatus.CREATED),HttpStatus.CREATED);
    }

    //edit
    @PutMapping("/{departId}")
    public ResponseEntity<DataResponse> updateDepartment(@PathVariable("departId")Integer cateId, @RequestBody Department department){
        return new ResponseEntity<>(new DataResponse(departmentService.updateDepartment(cateId,department), HttpStatus.OK),HttpStatus.OK);
    }

    @DeleteMapping("/{departId}")
    public ResponseEntity<DataResponse> deleteDepartment(@PathVariable("departId")Integer cateId){
        departmentService.deleteDepartment(cateId);
        return new ResponseEntity<>(new DataResponse("Da xoa thanh cong department", HttpStatus.NO_CONTENT),HttpStatus.OK);
    }

}
