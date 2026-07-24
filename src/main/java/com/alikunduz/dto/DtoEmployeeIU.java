package com.alikunduz.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DtoEmployeeIU {

    private String name;

    private String lastName;

    private BigDecimal salary;

    private Long departmentId;

}
