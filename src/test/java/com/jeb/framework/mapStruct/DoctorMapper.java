package com.jeb.framework.mapStruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper  简单场景使用
@Mapper(uses = PatientMapper.class)
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    @Mapping(source = "doctor.specialty", target = "specialization")
    DoctorDto toDto(Doctor doctor);

    /**
     * 多个对象合成一个
     */
    @Mapping(source = "doctor.specialty", target = "specialization")
    @Mapping(source = "education.degreeName", target = "degree")
    DoctorDto toDto(Doctor doctor, Education education);


    @Mapping(source = "doctor.patientList", target = "patientDtoList")
    @Mapping(source = "doctor.specialty", target = "specialization")
    DoctorDto toDto1(Doctor doctor);


}
