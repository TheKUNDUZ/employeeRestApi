package com.alikunduz.service.impl;


import com.alikunduz.dto.DtoDepartment;
import com.alikunduz.dto.DtoEmployee;
import com.alikunduz.dto.DtoEmployeeIU;
import com.alikunduz.entity.Department;
import com.alikunduz.entity.Employee;
import com.alikunduz.repository.EmployeeRepository;
import com.alikunduz.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public DtoEmployee findEmployeeById(Long id) {

        DtoEmployee dtoEmployee = new DtoEmployee();
        DtoDepartment dtodepartment = new DtoDepartment();

        Optional<Employee> optional = employeeRepository.findById(id);
        if (optional.isEmpty())
            return null;
        Employee employee = optional.get();
        Department department = employee.getDepartment();

        BeanUtils.copyProperties(employee, dtoEmployee);
        BeanUtils.copyProperties(department,dtodepartment);

        dtoEmployee.setDepartment(dtodepartment);

        return dtoEmployee;
    }



    @Override
    public DtoEmployee saveEmployee(DtoEmployeeIU dtoEmployeeIU) {
        Employee employee = new Employee();
        DtoEmployee dtoEmployee = new DtoEmployee();

        BeanUtils.copyProperties(dtoEmployeeIU, employee);

        Employee dbEmployee = employeeRepository.save(employee);

        BeanUtils.copyProperties(dbEmployee, dtoEmployee);

        return dtoEmployee;
    }



    @Override
    public List<DtoEmployee> getAllEmployees() {

        List<DtoEmployee> dtolist = new ArrayList<>();

        List<Employee> employeeList = employeeRepository.findAll();

        for (Employee employee : employeeList) {

            DtoEmployee dtoEmployee = new DtoEmployee();
            BeanUtils.copyProperties(employee, dtoEmployee);

            // bu kısım PostmandaVeriGelmemeSorunu.pdf dosyasında.
            if (employee.getDepartment() != null) {
                DtoDepartment dtoDepartment = new DtoDepartment();

                BeanUtils.copyProperties(employee.getDepartment(), dtoDepartment);


                dtoEmployee.setDepartment(dtoDepartment);
            }
            //
            dtolist.add(dtoEmployee);

        }
        return dtolist;
    }



    @Override
    public void deleteEmployee(Long id) {

        Optional<Employee> optional =employeeRepository.findById(id);
        if (optional.isPresent())
            employeeRepository.delete(optional.get());

    }


}
