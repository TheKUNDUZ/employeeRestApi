package com.alikunduz.controller.impl;

import com.alikunduz.controller.RestDepartmentController;
import com.alikunduz.dto.DtoDepartment;
import com.alikunduz.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
