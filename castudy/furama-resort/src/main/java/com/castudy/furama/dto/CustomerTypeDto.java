package com.castudy.furama.dto;

public class CustomerTypeDto {
    private Integer code;
    private String name;

    public CustomerTypeDto() {
    }

    public CustomerTypeDto(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
