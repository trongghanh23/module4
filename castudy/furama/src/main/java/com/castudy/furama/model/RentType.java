package com.castudy.furama.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "rentType")
public class RentType {
    @Id
    private Integer rentTypeId;
    private String rentTypeName;
    @OneToMany(mappedBy = "rentType")
    private List<Facility> facilityList;
}
