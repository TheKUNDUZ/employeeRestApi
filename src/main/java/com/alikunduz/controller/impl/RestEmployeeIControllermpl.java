package com.alikunduz.controller.impl;

import com.alikunduz.controller.RestEmployeeController;
import com.alikunduz.dto.DtoEmployee;
import com.alikunduz.dto.DtoEmployeeIU;
import com.alikunduz.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/employee")
public class RestEmployeeIControllermpl implements RestEmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @GetMapping(path = "/list/{id}")
    @Override
    public DtoEmployee findEmployeeById(@PathVariable(value = "id") Long id) {
        return employeeService.findEmployeeById(id);
    }

    @PostMapping(path = "/save")
    @Override
    public DtoEmployee saveEmployee(@RequestBody DtoEmployeeIU dtoEmployeeIU) {

        return employeeService.saveEmployee(dtoEmployeeIU);
    }

    @GetMapping(path = "/list")
    @Override
    public List<DtoEmployee> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @DeleteMapping(path = "/delete/{id}")
    @Override
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeService.deleteEmployee(id);

    }


}
