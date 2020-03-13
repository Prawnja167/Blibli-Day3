package com.blibli.binus.jpa.demojpa.service;

import com.blibli.binus.jpa.demojpa.entity.ClassSchedule;
import com.blibli.binus.jpa.demojpa.entity.Mahasiswa;

import java.util.List;

public interface ClassScheduleService {
  List<ClassSchedule> findByMahasiswa_Nim(String nim);
  void insert(ClassSchedule classSchedule, String nim);
  ClassSchedule findByCode(String code);
  void update(ClassSchedule classSchedule, String nim);
  void delete(String code);
}
