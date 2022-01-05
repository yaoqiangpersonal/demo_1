package com.example.demo;

import com.example.demo.validate.Demo;

import javax.validation.*;
import javax.validation.bootstrap.GenericBootstrap;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Set;

public class ValidateTest {
    public static void main(String[] args) throws NoSuchMethodException {

        GenericBootstrap bootstrap = Validation.byDefaultProvider();

        Configuration<?> configuration = bootstrap.configure();

        ValidatorFactory validatorFactory = configuration.buildValidatorFactory();

        Validator validator = validatorFactory.getValidator();

        Demo demo = new Demo();

        Method method = Demo.class.getMethod("demo",String.class);

        ExecutableValidator executableValidator = validator.forExecutables();
        Set<ConstraintViolation<Demo>> set = executableValidator.validateParameters(demo,method,new Object[]{"11"});
        set.forEach(c-> System.out.println(c.getMessage()));


    }
}
