package com.vtoebe.hogwartsstudentregister;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Hogwarts Student Register API"))
public class HogwartsStudentRegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(HogwartsStudentRegisterApplication.class, args);
	}

}
