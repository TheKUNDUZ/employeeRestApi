package com.alikunduz.controller;

import com.alikunduz.dto.DtoDepartment;
import com.alikunduz.dto.DtoDepartmentIU;

import java.util.List;

public interface RestDepartmentController {

    public List<DtoDepartment> getAllDepartment();

    public DtoDepartment findDepartmentById(Long id);

    public DtoDepartment saveDepartment(DtoDepartmentIU dtoDepartmentIU);

}
