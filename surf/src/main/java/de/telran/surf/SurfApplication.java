package de.telran.surf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "de.telran.surf")
public class SurfApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurfApplication.class, args);
	}

}
