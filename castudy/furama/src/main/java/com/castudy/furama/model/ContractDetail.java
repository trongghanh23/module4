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
@Table(name = "contracDetail")
public class ContractDetail {
    @Id
    private Integer detailId;
    private int quantity;
    @JoinColumn(name = "constractDetail",referencedColumnName = "id")
    @ManyToOne
    private  ContractDetail contractDetail;

//    @JoinColumn(name = "contract",referencedColumnName = "id")
//    @ManyToOne
//    private Contract  contract;



}
