package com.castudy.furama.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birthday;
    private String gender;
    private Integer idCard;
    private Integer phoneNumber;
    private String email;
    private String address;
    @JoinColumn(name = "customer_type",referencedColumnName = "code")
    @ManyToOne
    private CustomerType  customerType;
}
