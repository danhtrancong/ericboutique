package com.ericboutique.ericboutiquebe.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/no-auth/hello")
    private String sayHello(){
        return "Hello, how are you";
    }
}
