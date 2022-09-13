package com.castudy.furama.dto;


import com.castudy.furama.model.CustomerType;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Pattern;

public class CustomerDto  {

    private Integer customerId;


    @NotBlank(message = "please! input ")
    @Pattern(regexp = "[A-Za-z ]+", message = "No input number.please! input Abc-Bxy")
    private String name;
    @NotBlank(message = "please! input ")
    private String birthday;
    private Boolean gender;
    @Pattern(regexp = "^\\d{9}|\\d{12}$", message = "Id Card Must Have 9 / 12 number !")
    private Integer idCard;
    @Pattern(regexp = "^(090|091|8490|8491)+(\\d{7})$", message = "Phone Must Be Incorrect Format !")
    private Integer phoneNumber;

    @NotBlank(message = "please! input ")
    @Email
    private String email;
    @NotBlank(message = "please! input ")
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(Integer customerId, String name, String birthday, Boolean gender, Integer idCard, Integer phoneNumber, String email, String address, CustomerType customerType) {
        this.customerId = customerId;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getIdCard() {
        return idCard;
    }

    public void setIdCard(Integer idCard) {
        this.idCard = idCard;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }


}
