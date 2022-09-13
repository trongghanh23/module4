package com.example.demo.model;

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
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String name;
    private String dateOfBirthday;
    private int idCard;
    private double salary;
    private int phone;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "position",referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education",referencedColumnName = "educationId")
    private EducationDegree  educationDegree;

    @ManyToOne
    @JoinColumn(name = "division",referencedColumnName = "divisionId")
    private Division  division;

//    @OneToMany(mappedBy = "employee")




}
