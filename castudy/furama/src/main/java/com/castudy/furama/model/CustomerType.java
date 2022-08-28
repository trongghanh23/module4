package com.castudy.furama.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Table(name = "custome_type")

public class CustomerType {
    @Id
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;
}
