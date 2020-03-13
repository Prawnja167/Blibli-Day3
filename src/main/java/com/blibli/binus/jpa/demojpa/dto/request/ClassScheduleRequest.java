package com.blibli.binus.jpa.demojpa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassScheduleRequest {
  private String nim;
  private String code;
  private String name;
  private Date date;
}
