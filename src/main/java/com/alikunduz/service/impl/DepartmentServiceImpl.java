package com.alikunduz.service.impl;

import com.alikunduz.dto.DtoDepartment;
import com.alikunduz.dto.DtoDepartmentIU;
import com.alikunduz.entity.Department;
import com.alikunduz.entity.Employee;
import com.alikunduz.repository.DepartmentRepository;
import com.alikunduz.service.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public List<DtoDepartment> getAllDepartment() {

        List<DtoDepartment> dtoDepartmentList = new ArrayList<>();

        List<Department> dbDepartment = departmentRepository.findAll();
        for (Department department : dbDepartment) {
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(department , dtoDepartment);
            dtoDepartmentList.add(dtoDepartment);
        }

        return dtoDepartmentList;
    }



    @Override
    public DtoDepartment findDepartmentById(Long id) {

        Optional<Department> optional = departmentRepository.findById(id);
        if (optional.isEmpty()){
            return null;
        }
        DtoDepartment dtoDepartment = new DtoDepartment();

        BeanUtils.copyProperties(optional.get(), dtoDepartment);

        return dtoDepartment;
    }

    @Override
    public DtoDepartment saveDepartment(DtoDepartmentIU dtoDepartmentIU) {
        Department department = new Department();
        DtoDepartment dtoDepartment = new DtoDepartment();

        BeanUtils.copyProperties(dtoDepartmentIU, department);
        Department dbDepartment= departmentRepository.save(department);
        BeanUtils.copyProperties(dbDepartment,  dtoDepartment);

        return dtoDepartment;
    }
}
