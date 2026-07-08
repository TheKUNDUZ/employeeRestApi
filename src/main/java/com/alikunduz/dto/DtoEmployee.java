package com.alikunduz.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class DtoEmployee {

    private String name;

    private String lastName;

    private DtoDepartment department;


}
