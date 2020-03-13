package com.blibli.binus.jpa.demojpa.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//only get nim and name from incoming json
@JsonIgnoreProperties(ignoreUnknown = true)
public class MahasiswaRequest {
  private String nim;
  private String nama;
}
