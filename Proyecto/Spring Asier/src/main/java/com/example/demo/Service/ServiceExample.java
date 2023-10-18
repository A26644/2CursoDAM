package com.example.demo.Service;

import org.springframework.stereotype.Service;

@Service
public class ServiceExample {

    public String hello(String variable){
        return "Lo que he enviado es: " +  variable;
    }

    public Integer hello2(String variable){
        return 1;
    }
}
