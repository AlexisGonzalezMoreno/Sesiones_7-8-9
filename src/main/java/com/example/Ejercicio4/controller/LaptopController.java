package com.example.Ejercicio4.controller;

import com.example.Ejercicio4.entities.Laptop;
import com.example.Ejercicio4.repository.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {

    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    //attributes
    private LaptopRepository laptopRepository;

    //constructor
    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    //find all laptops
    @GetMapping("/api/laptops")
    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    @GetMapping("api/laptops/{id}")
    public Laptop findById(@PathVariable Long id) {
        Optional<Laptop> laptopOpt = laptopRepository.findById(id);

        if(laptopOpt.isPresent()) {
            return laptopOpt.get();
        }
        else {
            return null;
        }
    }

    @PostMapping("api/laptops/add")
    public Laptop addLaptop (@RequestBody Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    @PutMapping("api/laptops/update")
    public ResponseEntity<Laptop> updateLaptop(@RequestBody Laptop laptop) {
        if(laptop.getId() == null) {
            log.warn("You cannot update a non existent laptop");
            return ResponseEntity.badRequest().build();
        }
        if(!laptopRepository.existsById(laptop.getId())) {
            log.warn("You cannot update a non existent laptop");
            return ResponseEntity.notFound().build();
        }
        Laptop result = laptopRepository.save(laptop);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("api/laptops/deleteById/{id}")
    public ResponseEntity<Laptop> deleteById(@PathVariable Long id) {
        Optional<Laptop> laptopOptional = laptopRepository.findById(id);
        if(laptopOptional.isPresent()) {
            laptopRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        log.warn("You cannot delete a not existent laptop");
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("api/laptops/deleteAll")
    public ResponseEntity<Laptop> deleteAll() {
        laptopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
