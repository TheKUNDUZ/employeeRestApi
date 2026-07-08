package com.alikunduz.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DtoEmployeeIU {

    private String name;

    private String lastName;

    private BigDecimal salary;


}
