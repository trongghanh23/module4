package com.codegym.song.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SongDto implements Validator {

    private Integer id;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 800, message = "Tên không được quá 800 kí tự")
    private String name;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 300, message = "Tên không được quá 300 kí tự")
    private String artist;

    @NotBlank(message = "Tên không được để trống")
    @Size(max = 1000, message = "Tên không được quá 1000 kí tự")
    private String type;

    public SongDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (!songDto.name.matches("^[\\w\\s]+$")) {
            errors.rejectValue("name",
                    "not create.name",
                    "Tên không chứa kí tự đặc biệt");
        }
        if (!songDto.artist.matches("^[\\w\\s]+$")) {
            errors.rejectValue("artist",
                    "not create.artist",
                    "Tên không chưa kí tự đặc biệt");
        }
        if (!songDto.type.matches("^[\\w\\s,]*$")) {
            errors.rejectValue("type",
                    "not create.type",
                    "Ngoại trừ dấu phẩy “,”,không được chưa kí tự đặc biệt");
        }
    }

}
