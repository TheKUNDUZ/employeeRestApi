package com.alikunduz.service;

import com.alikunduz.dto.DtoDepartment;

import java.util.List;

public interface IDepartmentService {

    public List<DtoDepartment> getAllDepartment();

    public DtoDepartment findDepartmentById(Long id);


}
