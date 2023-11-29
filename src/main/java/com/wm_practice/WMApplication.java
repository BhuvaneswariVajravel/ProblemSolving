package com.wm_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WMApplication {

	public static void main(String[] args) {
		System.out.println("===started======");
		SpringApplication.run(WMApplication.class, args);
	}

}
