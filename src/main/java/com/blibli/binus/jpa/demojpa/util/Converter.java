package com.blibli.binus.jpa.demojpa.util;

import com.blibli.binus.jpa.demojpa.dto.request.ClassScheduleRequest;
import com.blibli.binus.jpa.demojpa.dto.request.MahasiswaRequest;
import com.blibli.binus.jpa.demojpa.dto.response.ClassScheduleResponse;
import com.blibli.binus.jpa.demojpa.dto.response.MahasiswaResponse;
import com.blibli.binus.jpa.demojpa.entity.ClassSchedule;
import com.blibli.binus.jpa.demojpa.entity.Mahasiswa;
import org.springframework.beans.BeanUtils;

public class Converter {
  public static MahasiswaResponse convertMahasiswaResponse(Mahasiswa mahasiswa) {
    MahasiswaResponse response = new MahasiswaResponse();
    BeanUtils.copyProperties(mahasiswa, response);

    return response;
  }

  public static Mahasiswa convertMahasiswaRequestToMahasiswa(MahasiswaRequest request) {
    Mahasiswa mahasiswa = new Mahasiswa();
    BeanUtils.copyProperties(request, mahasiswa);

    return mahasiswa;
  }

  public static ClassScheduleResponse convertClassScheduleResponse(ClassSchedule classSchedule) {
    ClassScheduleResponse response = new ClassScheduleResponse();
    BeanUtils.copyProperties(classSchedule, response);
    response.setMahasiswaResponse(Converter.convertMahasiswaResponse(classSchedule.getMahasiswa()));

    return response;
  }

  public static ClassSchedule convertClassScheduleRequestToClassSchedule(ClassScheduleRequest request) {
    ClassSchedule classSchedule = new ClassSchedule();
    BeanUtils.copyProperties(request, classSchedule);

    return classSchedule;
  }
}
