package com.jeb.framework.mapStruct;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @Date 2023-12-09 09:45
 * @Author GuYue
 */
public class DoctorTest {
    @Test
    /**
     * 属性不同映射
     */
    public void test1() {
        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("张三");
        doctor.setSpecialty("内科");
        DoctorDto doctorDto = DoctorMapper.INSTANCE.toDto(doctor);
        System.out.println(doctorDto);
    }

    @Test
    /**
     * 多个对象合成一个
     */
    public void test2() {
        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("张三");
        doctor.setSpecialty("内科");

        Education education = new Education();
        education.setDegreeName("硕士");
        education.setInstitute("清华大学");
        education.setYearOfPassing(2010);

        DoctorDto doctorDto = DoctorMapper.INSTANCE.toDto(doctor,education);
        System.out.println(doctorDto);
    }


    @Test
    /**
     * 对象包含列表
     */
    public void test3() {
        Doctor doctor = new Doctor();
        doctor.setId(1);
        doctor.setName("张三");
        doctor.setSpecialty("内科");


        ArrayList<Patient> patients = new ArrayList<>();
        Patient patient = new Patient();
        patient.setId(1);
        patient.setName("张三");
        patients.add(patient);


        doctor.setPatientList(patients);

        DoctorDto doctorDto = DoctorMapper.INSTANCE.toDto1(doctor);
        System.out.println(doctorDto);
    }
}
