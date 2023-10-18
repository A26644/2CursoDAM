package com.example.demo.controller;

import com.example.demo.Service.ServiceExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v1")
public class controller {

    @Autowired
    ServiceExample service;

    @GetMapping("/hello")
    public ResponseEntity<?> helloWorld(@RequestParam String variable) {
        return new ResponseEntity<>(service.hello2(variable), HttpStatus.OK);
    }
    public ResponseEntity<String> hello2World(@RequestParam String variable) {
        return new ResponseEntity<>("hola", HttpStatus.OK);
    }
}
