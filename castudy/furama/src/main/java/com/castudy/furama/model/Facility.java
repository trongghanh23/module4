package com.castudy.furama.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int numberFloors;
    private String facilityFree;
    @JoinColumn(name = "facility_type",referencedColumnName = "typeId")
    @ManyToOne
    private FacilityType  facilityType;
    @JoinColumn(name = "rent_type",referencedColumnName = "rentTypeId")
    @ManyToOne
    private RentType rentType;
}
