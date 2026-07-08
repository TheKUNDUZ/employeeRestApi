package com.alikunduz.controller;

import com.alikunduz.dto.DtoEmployee;
import com.alikunduz.dto.DtoEmployeeIU;

import java.util.List;

public interface RestEmployeeController {

    public DtoEmployee findEmployeeById(Long id);

    public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU);

    public List<DtoEmployee> getAllEmployees();

    public void deleteEmployee(Long id);

    public DtoEmployee updateEmployee(Long id, DtoEmployeeIU dtoEmployeeIU);
}
