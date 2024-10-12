package com.awesome.typing1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Typing1Application {

	public static void main(String[] args) {
		SpringApplication.run(Typing1Application.class, args);
	}

}
