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
@Table(name = "education")
public class EducationDegree {
    @Id
    private Integer educationId;
    private String name;

    @OneToMany(mappedBy = "educationDegree")
    List<Employee>employeeList;

}
