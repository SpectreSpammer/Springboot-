package com.cwt.collaberaSpringBoot2.cwt_collabera_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication
public class CwtCollaberaSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(CwtCollaberaSpringbootApplication.class, args);
	}

}
