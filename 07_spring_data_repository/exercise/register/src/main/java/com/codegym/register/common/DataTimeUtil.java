package com.codegym.register.common;


import com.codegym.register.dto.UserDto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;

public class DataTimeUtil {

    public static void checkAge(UserDto userDto, Errors errors) {

        try {
            String age = userDto.getAge();
            LocalDate localDate = LocalDate.parse(age);
            int checkAge = Period.between(localDate, LocalDate.now()).getYears();
            if (checkAge < 18) {
                errors.rejectValue("age", "create.age", "tuổi phải lớn hơn 18 hoặc bằng 18");
            }
        } catch (Exception e) {
            errors.rejectValue("age", "create.age", "Vui Lòng nhập vào không để trống");
        }

    }


}
