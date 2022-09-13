package com.castudy.furama.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String name;
    private String birthday;
    private Boolean gender;
    private Integer idCard;
    private Integer phoneNumber;
    private String email;
    private String address;

    @ManyToOne
    @JoinColumn(name = "customerType",referencedColumnName = "code")
    private CustomerType  customerType;
//
//    @OneToMany(mappedBy = "customer")
//    private List<Contract>contractList;
}
