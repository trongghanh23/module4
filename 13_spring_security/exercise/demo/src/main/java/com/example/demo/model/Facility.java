package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer facilityId;
    private String name;
    private double area;
    private double cost;
    private int maxPeople;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int numberFloors;
    private String facilityFree;

    @JoinColumn(name = "facilityType",referencedColumnName = "typeId")
    @ManyToOne
    private FacilityType  facilityType;

    @JoinColumn(name = "rentType",referencedColumnName = "rentTypeId")
    @ManyToOne
    private RentType rentType;

//    @OneToMany(mappedBy = "facility")
//    List<Contract>contractList;
}
