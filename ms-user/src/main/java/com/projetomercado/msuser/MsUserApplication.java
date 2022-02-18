package com.projetomercado.msuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableEurekaClient
@SpringBootApplication
public class MsUserApplication {

	@Autowired
	private BCryptPasswordEncoder password;
	
	public static void main(String[] args) {
		SpringApplication.run(MsUserApplication.class, args);
	}

}
