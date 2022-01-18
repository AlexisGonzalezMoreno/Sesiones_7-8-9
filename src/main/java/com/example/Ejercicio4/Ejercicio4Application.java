package com.example.Ejercicio4;

import com.example.Ejercicio4.entities.Laptop;
import com.example.Ejercicio4.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio4Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio4Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);


		Laptop laptop1 = new Laptop(null, "LG", 449.99, "HGT", 4, true);
		Laptop laptop2 = new Laptop(null, "Sony", 699.99, "PGT", 3, false);

		System.out.println("Numero de laptops: " + repository.findAll().size());

		//save laptops
		repository.save(laptop1);
		repository.save(laptop2);

		System.out.println("Numero de laptops: " + repository.findAll().size());

		//repository.deleteById(1L);

		System.out.println("Numero de laptops: " + repository.findAll().size());
	}

}
