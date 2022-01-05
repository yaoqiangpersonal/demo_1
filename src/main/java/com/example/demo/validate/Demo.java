package com.example.demo.validate;

public class Demo {

    public void demo(@StringLength(minLength = 10,maxLength = 20,message = "error")String str){
        System.out.println(str);
    }
}
