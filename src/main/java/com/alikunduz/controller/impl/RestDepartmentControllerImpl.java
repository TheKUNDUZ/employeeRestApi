package com.alikunduz.controller.impl;

import com.alikunduz.controller.RestDepartmentController;
import com.alikunduz.dto.DtoDepartment;
import com.alikunduz.dto.DtoDepartmentIU;
import com.alikunduz.dto.DtoEmployeeIU;
import com.alikunduz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/department")
public class RestDepartmentControllerImpl implements RestDepartmentController {



    @Autowired
    IDepartmentService departmentService;

    @GetMapping(path = "/list")
    @Override
    public List<DtoDepartment> getAllDepartment() {

        return departmentService.getAllDepartment();
    }



    @GetMapping(path = "/{id}")
    @Override
    public DtoDepartment findDepartmentById(@PathVariable(value = "id") Long id) {

        return departmentService.findDepartmentById(id);
    }

    @PostMapping(path = "/save")
    @Override
    public DtoDepartment saveDepartment(@RequestBody DtoDepartmentIU dtoDepartmentIU) {

        return departmentService.saveDepartment(dtoDepartmentIU);
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteDepartment(@PathVariable(value = "id") Long id) {
        departmentService.deleteDepartment(id);
    }

    @PutMapping(path = "/update/{id}")
    @Override
    public DtoDepartment updateDepartment(@PathVariable(value = "id") long id,@RequestBody DtoEmployeeIU dtoEmployeeIU) {
        return departmentService.updateDepartment(id, dtoEmployeeIU);
    }
}
