package com.castudy.furama.common.customer;

import com.castudy.furama.dto.CustomerDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;

public class CustomerValidate {
    public static void checkName(CustomerDto customerDto, Errors errors){

        if (!customerDto.getName().isEmpty()){
            if (!customerDto.getName().matches("^([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})([a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}([A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]{1})[a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+))+$")){
                errors.rejectValue("name",
                        "create",
                        "No contain special characters and numbers, capitalize the first letter !");
            }
        }else {
            errors.rejectValue("name",
                    "create.name",
                    "Please enter !");
        }

    }

    public static void checkIdCard(CustomerDto customerDto, Errors errors){
        if(!customerDto.getIdCard().isEmpty()){
            if (!customerDto.getIdCard().matches("^(\\d{9}|\\d{12})$")){
                errors.rejectValue("idCard",
                        "create.idCard",
                        "Wrong format ! include 9 or 12 numbers");
            }
        }else {
            errors.rejectValue("idCard",
                    "create.idCard",
                    "Please enter !");
        }

    }
    public static void checkAddress(CustomerDto customerDto, Errors errors) {
        if (customerDto.getAddress().isEmpty()){
            errors.rejectValue("address",
                    "create.address",
                    "Please enter !");
        }
    }
    public static void checkPhoneNumber(CustomerDto customerDto, Errors errors){
        if(!customerDto.getPhoneNumber().isEmpty()){
            if (!customerDto.getPhoneNumber().matches("^(090|091|8490|8491)\\d{7}$")){
                errors.rejectValue("phoneNumber",
                        "create.phoneNumber",
                        "Wrong format ! ex: include 10 or 11 numbers. Start with 090 - 091 - 8490 - 8491");
            }
        }else {
            errors.rejectValue("phoneNumber",
                    "create.phoneNumber",
                    "Please enter !");
        }

    }
    public static void checkAge(CustomerDto customerDto, Errors errors) {
        if (!customerDto.getBirthday().isEmpty()){
            try {
                LocalDate age = LocalDate.parse(customerDto.getBirthday());

                int checkAge = Period.between(age, LocalDate.now()).getYears();

                if (checkAge < 18){
                    errors.rejectValue("birthday",
                            "create.age",
                            "under 18 years old !");
                }
            }catch (DateTimeParseException e){
                errors.rejectValue("birthday",
                        "create.age",
                        "Wrong format !");
            }
        }else {
            errors.rejectValue("birthday",
                    "create.age",
                    "Please enter !");
        }
    }


}
