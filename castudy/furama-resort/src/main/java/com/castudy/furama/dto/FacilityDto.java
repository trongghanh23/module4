package com.castudy.furama.dto;

import com.castudy.furama.common.facility.FacilityValidate;
import com.castudy.furama.model.Facility;
import com.castudy.furama.model.FacilityType;
import com.castudy.furama.model.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;





public class FacilityDto implements Validator {
    private Integer facilityId;
    private String name;
    private Double area;
    private Double cost;
    private Integer maxPeople;
    private String standardRoom;
    private String description;
    private Double poolArea;
    private Integer numberFloors;
    private String facilityFree;
    private FacilityType facilityType;
    private RentType rentType;

    public FacilityDto() {
    }

    public FacilityDto(Integer facilityId, String name, Double area, Double cost, Integer maxPeople, String standardRoom, String description, Double poolArea, Integer numberFloors, String facilityFree, FacilityType facilityType, RentType rentType) {
        this.facilityId = facilityId;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(Integer numberFloors) {
        this.numberFloors = numberFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

        FacilityValidate.checkName(facilityDto, errors);
        FacilityValidate.checkArea(facilityDto,errors);
        FacilityValidate.checkCost(facilityDto,errors);
        FacilityValidate.checkMaxPeople(facilityDto,errors);
        FacilityValidate.checkPoolArea(facilityDto,errors);
        FacilityValidate.checkFloors(facilityDto,errors);
    }
}
