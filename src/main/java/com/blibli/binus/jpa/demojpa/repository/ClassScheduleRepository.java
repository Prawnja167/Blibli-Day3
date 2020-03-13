package com.blibli.binus.jpa.demojpa.repository;

import com.blibli.binus.jpa.demojpa.entity.ClassSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {
  List<ClassSchedule> findByMahasiswa_Nim(String nim);
  ClassSchedule findByCode(String code);
}
