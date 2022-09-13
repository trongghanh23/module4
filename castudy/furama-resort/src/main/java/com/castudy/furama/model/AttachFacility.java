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
@Getter
@Setter
@Entity
@Table(name = "attachFacility")
public class AttachFacility {
    @Id
    private Integer attachId;
    private String name;
    private double cost;
    private String unit;
    private String status;

    @OneToMany(mappedBy = "attachFacility")
    private List<ContractDetail>contractDetailList;

}
