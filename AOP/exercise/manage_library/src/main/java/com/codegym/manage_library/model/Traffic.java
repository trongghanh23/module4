package com.codegym.manage_library.model;

import javax.persistence.*;

@Entity
@Table
public class Traffic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;

    public Traffic() {
    }

    public Traffic(Integer id, Integer quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
