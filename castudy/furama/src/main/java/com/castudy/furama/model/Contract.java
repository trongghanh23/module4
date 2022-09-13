package com.castudy.furama.model;

import lombok.*;

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

//    @OneToMany(mappedBy = "contractDetail")
//    private List<ContractDetail>contractDetailList;

//    @ManyToOne
//    @JoinColumn(name = "facility",referencedColumnName = "facilityId")
//    private  Facility facility;
//
//    @ManyToOne
//    @JoinColumn(name = "customer",referencedColumnName = "customerId")
//    private Customer customer;

//    @ManyToOne
//    @JoinColumn(name = "employee",referencedColumnName = "employeeId")
//    private Employee employee;
//
//    @OneToMany(mappedBy = "contract")
//    private List<ContractDetail> contractDetails;

}
