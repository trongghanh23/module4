package com.castudy.furama.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "attachFacility")
public class AttachFacility {
    @Id
    private Integer attachId;
    private String name;
    private Double cost;
    private String unit;
    private String status;

    @OneToMany(mappedBy = "attachFacility")

    @JsonBackReference
    private Set<ContractDetail> contractDetailList;

    public AttachFacility() {
    }

    public AttachFacility(Integer attachId, String name, Double cost, String unit, String status, Set<ContractDetail> contractDetailList) {
        this.attachId = attachId;
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetailList = contractDetailList;
    }

    public Integer getAttachId() {
        return attachId;
    }

    public void setAttachId(Integer attachId) {
        this.attachId = attachId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(Set<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }
}
