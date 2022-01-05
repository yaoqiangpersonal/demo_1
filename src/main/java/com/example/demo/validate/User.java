package com.example.demo.validate;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
public class User {

    private String name;

    @Min(value = 788942812000L)
    @Max(value = 4102469212000L)
    private long age;
}
