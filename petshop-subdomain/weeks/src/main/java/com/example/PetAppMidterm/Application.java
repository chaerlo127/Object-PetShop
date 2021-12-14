package com.example.PetAppMidterm;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@RestController
@EnableAspectJAutoProxy

public class Application {


	static String[] names = {"젤리", "대박이", "감자", "사랑", "자몽이", "꼬맹이", "몽이", "모리", "하리", "해피", "하트", "콩", "태양"};
	// static HashMap<String, Pet> pets = new HashMap<String, Pet>();
	

	public static void main(String[] args) {
		// pets.put(Dog.class.getSimpleName().toLowerCase(),  new Dog());
		// pets.put(Cat.class.getSimpleName().toLowerCase(), new Cat());
		SpringApplication.run(Application.class, args);
	}



}

