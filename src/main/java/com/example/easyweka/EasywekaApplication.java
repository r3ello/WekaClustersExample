package com.example.easyweka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EasywekaApplication implements CommandLineRunner {
     
	@Autowired
	KMeansService kMeansService;
	public static void main(String[] args) {
		SpringApplication.run(EasywekaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("EasywekaApplication.run()");
		kMeansService.Cluster();
		
	}

}
