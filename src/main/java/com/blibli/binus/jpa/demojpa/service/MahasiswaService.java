package com.blibli.binus.jpa.demojpa.service;

import com.blibli.binus.jpa.demojpa.entity.Mahasiswa;

public interface MahasiswaService {
  Mahasiswa findByNim(String nim);
  Mahasiswa findById(Long id);
  void insert(Mahasiswa mahasiswa);
  void update(Mahasiswa mahasiswa);
  void delete(String nim);
}
