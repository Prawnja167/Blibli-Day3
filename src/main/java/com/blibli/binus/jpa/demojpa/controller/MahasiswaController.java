package com.blibli.binus.jpa.demojpa.controller;

import com.blibli.binus.jpa.demojpa.dto.request.MahasiswaRequest;
import com.blibli.binus.jpa.demojpa.dto.response.BaseResponse;
import com.blibli.binus.jpa.demojpa.dto.response.MahasiswaResponse;
import com.blibli.binus.jpa.demojpa.entity.Mahasiswa;
import com.blibli.binus.jpa.demojpa.service.MahasiswaService;
import com.blibli.binus.jpa.demojpa.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mahasiswa")
public class MahasiswaController {

  @Autowired
  MahasiswaService mahasiswaService;

  @GetMapping("/findByNim")
  public MahasiswaResponse findByNim(@RequestParam String nim) {
    Mahasiswa mahasiswa = mahasiswaService.findByNim(nim);

    return Converter.convertMahasiswaResponse(mahasiswa);
  }

  @PostMapping("/insert")
  public BaseResponse insert(@RequestBody MahasiswaRequest request) {
    Mahasiswa mahasiswa = Converter.convertMahasiswaRequestToMahasiswa(request);

    try {
      mahasiswaService.insert(mahasiswa);
      return new BaseResponse(true, null);
    } catch (Exception e) {
      return new BaseResponse(false, e.getMessage());
    }

  }

  @PutMapping("/update")
  public BaseResponse update(@RequestBody MahasiswaRequest request) {
    Mahasiswa mahasiswa = Converter.convertMahasiswaRequestToMahasiswa(request);

    try {
      mahasiswaService.update(mahasiswa);
      return new BaseResponse(true, null);
    } catch (Exception e) {
      return new BaseResponse(false, e.getMessage());
    }

  }
}
