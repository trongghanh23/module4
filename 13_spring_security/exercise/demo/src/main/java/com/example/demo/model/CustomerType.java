package com.example.demo.model;

import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customerType")

public class CustomerType {
    @Id
    private Integer code;
    private String name;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;
}
