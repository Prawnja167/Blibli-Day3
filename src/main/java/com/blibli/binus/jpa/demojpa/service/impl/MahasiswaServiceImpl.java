package com.blibli.binus.jpa.demojpa.service.impl;

import com.blibli.binus.jpa.demojpa.entity.Mahasiswa;
import com.blibli.binus.jpa.demojpa.repository.MahasiswaRepository;
import com.blibli.binus.jpa.demojpa.service.MahasiswaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MahasiswaServiceImpl implements MahasiswaService {
  @Autowired
  private MahasiswaRepository mahasiswaRepository;

  @Override
  public Mahasiswa findByNim(String nim) {
    return mahasiswaRepository.findByNim(nim);
  }

  @Override
  public Mahasiswa findById(Long id) {
    return mahasiswaRepository.findById(id).get();
  }

  @Override
  public void insert(Mahasiswa mahasiswa) {
    mahasiswaRepository.save(mahasiswa);
  }

  @Override
  public void update(Mahasiswa mahasiswa) {
    Mahasiswa existing = findByNim(mahasiswa.getNim());
    BeanUtils.copyProperties(mahasiswa, existing, "id");

    mahasiswaRepository.save(existing);
  }

  @Override
  public void delete(String nim) {
    Mahasiswa mahasiswa = findByNim(nim);

    mahasiswaRepository.delete(mahasiswa);
  }
}
