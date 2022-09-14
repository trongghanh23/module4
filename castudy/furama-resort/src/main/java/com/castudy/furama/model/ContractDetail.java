package com.castudy.furama.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;


@Entity
@Table(name = "contracDetail")
public class ContractDetail {
    @Id
    private Integer detailId;
    private Integer quantity;
    @JsonBackReference
    @JoinColumn(name = "contract",referencedColumnName = "id")
    @ManyToOne
    private Contract  contract;


    @JoinColumn(name = "attachFacility",referencedColumnName = "attachId")
    @ManyToOne
    private AttachFacility attachFacility;


    public ContractDetail() {
    }

    public ContractDetail(Integer detailId, Integer quantity, Contract contract, AttachFacility attachFacility) {
        this.detailId = detailId;
        this.quantity = quantity;
        this.contract = contract;
        this.attachFacility = attachFacility;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }
}
