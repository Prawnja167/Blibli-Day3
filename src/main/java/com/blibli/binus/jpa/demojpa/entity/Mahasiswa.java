package com.blibli.binus.jpa.demojpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@Entity(name = "mahasiswa")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "nim")
})
public class Mahasiswa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nim")
  private String nim;

  @Column(name = "nama")
  private String nama;

  //eager : fetch datanya dl sebelum di request
  //lacy : fetch by request
  @OneToMany(mappedBy = "mahasiswa", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<ClassSchedule> classSchedules;
}
