package com.blibli.binus.jpa.demojpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity(name="class_schedule")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassSchedule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "code")
  private String code;

  @Column(name = "date")
  private Date date;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "mahasiswa_fk", nullable = false)
  private Mahasiswa mahasiswa;
}
