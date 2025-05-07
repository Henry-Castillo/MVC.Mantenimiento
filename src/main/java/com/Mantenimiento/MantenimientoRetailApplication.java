package com.Mantenimiento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MantenimientoRetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(MantenimientoRetailApplication.class, args);
	}
    @GetMapping("/users/health")
    public String health() { return "OK from User"; }
}
