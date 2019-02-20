package com.example.demo;

import com.example.demo.baseController.BaseController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
//		BaseController baseController = new BaseController();
//		baseController.generate();
		System.out.println("OKOKOKOK");
	}

}

