package com.blibli.binus.jpa.demojpa.service.impl;

import com.blibli.binus.jpa.demojpa.entity.ClassSchedule;
import com.blibli.binus.jpa.demojpa.entity.Mahasiswa;
import com.blibli.binus.jpa.demojpa.repository.ClassScheduleRepository;
import com.blibli.binus.jpa.demojpa.service.ClassScheduleService;
import com.blibli.binus.jpa.demojpa.service.MahasiswaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassScheduleServiceImpl implements ClassScheduleService {

  @Autowired
  ClassScheduleRepository classScheduleRepository;

  @Autowired
  MahasiswaService mahasiswaService;

  @Override
  public List<ClassSchedule> findByMahasiswa_Nim(String nim) {
    return classScheduleRepository.findByMahasiswa_Nim(nim);
  }

  @Override
  public void insert(ClassSchedule classSchedule, String nim) {
    Mahasiswa mahasiswa = mahasiswaService.findByNim(nim);
    classSchedule.setMahasiswa(mahasiswa);

    classScheduleRepository.save(classSchedule);
  }

  @Override
  public ClassSchedule findByCode(String code) {
    return classScheduleRepository.findByCode(code);
  }

  @Override
  public void update(ClassSchedule classSchedule, String nim) {
    ClassSchedule existing = findByCode(classSchedule.getCode());
    BeanUtils.copyProperties(classSchedule, existing, "id");

    classScheduleRepository.save(existing);
  }

  @Override
  public void delete(String code) {
    ClassSchedule classSchedule = classScheduleRepository.findByCode(code);
    classScheduleRepository.delete(classSchedule);
  }
}
