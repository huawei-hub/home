package com.hua.demo.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Data
public class TestDemo {

    @NotBlank
    @Length(min = 0,max = 10)
    private Integer id;
    @Email
    private String username;
}
