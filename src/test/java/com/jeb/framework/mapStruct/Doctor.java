package com.jeb.framework.mapStruct;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import java.util.List;

@Data
public class Doctor {
    private int id;
    private String name;
    private String specialty;
    private List<Patient> patientList;
    private Integer age;
}