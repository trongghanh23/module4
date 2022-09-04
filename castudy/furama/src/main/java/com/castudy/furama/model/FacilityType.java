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
@Table(name = "facility_type")
public class FacilityType {
    @Id
    private Integer typeId;
    private String typeName;
    @OneToMany(mappedBy = "facilityType")
    private List<Facility> facilityList;
}
