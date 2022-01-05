package com.example.demo.validate;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class StringLengthValidator implements ConstraintValidator<StringLength, String> {

    private StringLength stringLength;

    @Override
    public void initialize(StringLength constraintAnnotation) {
        this.stringLength = constraintAnnotation;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (Objects.isNull(value)) {
            return true;
        }
        if (null != stringLength) {
            int length = value.length();
            int maxLen = stringLength.maxLength(),
                    minLen = stringLength.minLength();
            return length >= minLen && length <= maxLen;
        }
        return false;
    }
}

