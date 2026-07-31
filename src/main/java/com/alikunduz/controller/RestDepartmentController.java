package com.alikunduz.controller;

import com.alikunduz.dto.DtoDepartment;
import com.alikunduz.dto.DtoDepartmentIU;
import com.alikunduz.dto.DtoEmployeeIU;

import java.util.List;

public interface RestDepartmentController {

    public List<DtoDepartment> getAllDepartment();

    public DtoDepartment findDepartmentById(Long id);

    public DtoDepartment saveDepartment(DtoDepartmentIU dtoDepartmentIU);

    public void deleteDepartment(Long id);

    public DtoDepartment updateDepartment(long id, DtoDepartmentIU dtoDepartmentIU);

}
