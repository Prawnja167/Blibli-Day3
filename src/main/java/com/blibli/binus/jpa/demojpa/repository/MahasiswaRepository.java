package com.blibli.binus.jpa.demojpa.repository;

import com.blibli.binus.jpa.demojpa.entity.Mahasiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MahasiswaRepository extends JpaRepository<Mahasiswa, Long> {
  Mahasiswa findByNim(String nim);
}
