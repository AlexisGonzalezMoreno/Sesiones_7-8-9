package com.example.Ejercicio4.controller;

import com.example.Ejercicio4.repository.LaptopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/saludo")
    public String unSaludo() {
        return "Un saludo!! otro :)";
    }
}
