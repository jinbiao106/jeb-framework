package com.jeb.framework.mapStruct;

import lombok.Data;

import java.util.List;

@Data
public class DoctorDto {
    private int id;
    private String name;
    private String specialization;
    private String degree;
    private Integer sex;
    private List<PatientDto> patientDtoList;
}