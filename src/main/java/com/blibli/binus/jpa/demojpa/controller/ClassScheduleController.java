package com.blibli.binus.jpa.demojpa.controller;

import com.blibli.binus.jpa.demojpa.dto.request.ClassScheduleRequest;
import com.blibli.binus.jpa.demojpa.dto.response.BaseResponse;
import com.blibli.binus.jpa.demojpa.dto.response.ClassScheduleResponse;
import com.blibli.binus.jpa.demojpa.entity.ClassSchedule;
import com.blibli.binus.jpa.demojpa.service.ClassScheduleService;
import com.blibli.binus.jpa.demojpa.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/class-schedule")
public class ClassScheduleController {

  @Autowired
  ClassScheduleService classScheduleService;

  @GetMapping("/get")
  public ClassScheduleResponse findByCode(@RequestParam String code) {
    ClassSchedule classSchedule = classScheduleService.findByCode(code);

    return Converter.convertClassScheduleResponse(classSchedule);
  }

  @PostMapping("/insert")
  public BaseResponse insertClassSchedule(@RequestBody ClassScheduleRequest classScheduleRequest) {
    ClassSchedule classSchedule = Converter.convertClassScheduleRequestToClassSchedule(classScheduleRequest);

    try {
      classScheduleService.insert(classSchedule, classScheduleRequest.getNim());
      return new BaseResponse(true, null);
    } catch (Exception e) {
      return new BaseResponse(false, e.getMessage());
    }
  }
}
