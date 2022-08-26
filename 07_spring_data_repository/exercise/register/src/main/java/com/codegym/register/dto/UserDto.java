package com.codegym.register.dto;

import com.codegym.register.common.DataTimeUtil;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDto implements Validator {

    private Integer id;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(min = 5, max = 45)
    @Pattern(regexp = "[A-Za-z ]+", message = "Nhập sai định dạng.ký tự phải trong khoảng 5-45 kí Tự và viết hoa chữ đầu Vui lòng nhập lại")
    private String lastName;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Size(min = 5, max = 45)
    @Pattern(regexp = "[A-Za-z ]+", message = "Nhập sai định dạng.ký tự phải trong khoảng 5-45 kí Tự và viết hoa chữ đầu Vui lòng nhập lại")
    private String firstName;

    @NotBlank(message = "Vui lòng nhập vào!!!")
    @Pattern(regexp = "((09)[0-9]){10}", message = "Nhập sai định dạng. Vui lòng nhập lại!!!")
    String phoneNumber;

    private String age;

    @Email(message = "vui lòng nhập định dạng email:")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        DataTimeUtil.checkAge(userDto, errors);


    }

}
