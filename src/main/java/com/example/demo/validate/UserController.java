package com.example.demo.validate;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("validate")
public class UserController {

    @PostMapping("execute")
    public void execute(@Valid @RequestBody @StringLength(minLength = 10, maxLength = 20, message = "error") String str) {
        System.out.println(str);
    }

}
