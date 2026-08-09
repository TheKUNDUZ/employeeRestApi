package com.alikunduz.service.impl;

import com.alikunduz.dto.DtoDepartment;
import com.alikunduz.dto.DtoDepartmentIU;
import com.alikunduz.dto.DtoEmployeeIU;
import com.alikunduz.entity.Department;
import com.alikunduz.entity.Employee;
import com.alikunduz.repository.DepartmentRepository;
import com.alikunduz.service.IDepartmentService;
import jakarta.persistence.EntityNotFoundException;
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

    @Override
    public void deleteDepartment(Long id) {
       DtoDepartment dbDepartment = findDepartmentById(id);
        departmentRepository.deleteById(dbDepartment.getId());
    }



    @Override
    public DtoDepartment updateDepartment(long id, DtoDepartmentIU dtoDepartmentIU) {

        DtoDepartment dtoDepartment = new DtoDepartment();

        Optional<Department> dbDepartment = departmentRepository.findById(id);
        if (dbDepartment.isEmpty()){
            return null;
        }

        Department department = dbDepartment.get();
        BeanUtils.copyProperties(dtoDepartmentIU,department);

        departmentRepository.save(department);

        BeanUtils.copyProperties(department,  dtoDepartment);


        return dtoDepartment;
    }


/*
@Override
    public DtoDepartment updateDepartment(long id, DtoDepartmentIU dtoDepartmentIU) {

        Department department = new Department();

        DtoDepartment dtoDepartment = findDepartmentById(id);
        BeanUtils.copyProperties(dtoDepartment, department);

        BeanUtils.copyProperties(dtoDepartmentIU, department);

        departmentRepository.save(department);

        BeanUtils.copyProperties(department,  dtoDepartment);



        return dtoDepartment;
    }
 */








    /*
    @Override

    public DtoDepartment updateDepartment(long id, DtoDepartmentIU dtoDepartmentIU) {


        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Departman bulunamadı. ID: " + id));


        BeanUtils.copyProperties(dtoDepartmentIU, department);


        Department updatedDepartment = departmentRepository.save(department);


        DtoDepartment responseDto = new DtoDepartment();
        BeanUtils.copyProperties(updatedDepartment, responseDto);

        return responseDto;
    }
    */




    //              ESKİ HALİ

    /*  @Override
    public DtoDepartment updateDepartment(long id, DtoEmployeeIU dtoEmployeeIU) {

        Department department = new Department();

        DtoDepartment dtoDepartment = findDepartmentById(id);
        BeanUtils.copyProperties(dtoDepartment, department);

        BeanUtils.copyProperties(dtoEmployeeIU, department);

       departmentRepository.save(department);

       BeanUtils.copyProperties(department,  dtoDepartment);



        return dtoDepartment;
    }
     */
}
