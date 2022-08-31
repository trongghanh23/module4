package com.castudy.furama.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String birthday;
    private Boolean gender;
    private Integer idCard;
    private Integer phoneNumber;
    private String email;
    private String address;
    @JoinColumn(name = "customer_type",referencedColumnName = "code")
    @ManyToOne
    private CustomerType  customerType;
}
