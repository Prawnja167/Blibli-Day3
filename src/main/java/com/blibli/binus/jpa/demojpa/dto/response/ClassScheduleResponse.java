package com.blibli.binus.jpa.demojpa.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassScheduleResponse {
  private String code;
  private String name;
  private Date date;
  private MahasiswaResponse mahasiswaResponse;
}
