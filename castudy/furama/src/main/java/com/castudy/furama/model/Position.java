package com.castudy.furama.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "position")
public class Position {
    @Id
    private Integer positionId;
    private String name;

    @OneToMany(mappedBy = "position")
    List<Employee> employeeList;
}
