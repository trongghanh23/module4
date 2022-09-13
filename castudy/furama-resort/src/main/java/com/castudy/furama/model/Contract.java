package com.castudy.furama.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "contract")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String startDay;
    private String endDay;
    private double deposit;


    @ManyToOne
    @JoinColumn(name = "facility",referencedColumnName = "facilityId")
    private  Facility facility;

    @ManyToOne
    @JoinColumn(name = "customer",referencedColumnName = "customerId")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee",referencedColumnName = "employeeId")
    private Employee employee;

    @OneToMany(mappedBy = "contract")
    private List<ContractDetail> contractDetailList;


}
