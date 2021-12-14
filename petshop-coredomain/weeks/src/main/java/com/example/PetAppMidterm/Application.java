package com.example.PetAppMidterm;


import com.example.PetAppMidterm.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


	//ICart 변경 시 변경을 해줘야 하는 것임
	@Autowired
	PetRepository petRepository;

	//localhost:8080/pets/__/feed, api put
	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/feed")
	public String feed(@PathVariable(value = "petId") Long petId){

		//CrudRepository 내장되어 있는 method findByID 사용
		Pet thePet = petRepository.findById(petId).get();

		thePet.eat();//energy 증가
		petRepository.save(thePet); //database에 저장

		return "맛있는 거 먹었습니다.";

	}
	//localhost:8080/pets/__/sleep, api put
	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/sleep")
	public String sleep(@PathVariable(value = "petId") Long petId){

		//CrudRepository 내장되어 있는 method findByID 사용
		Pet thePet = petRepository.findById(petId).get();
		thePet.sleep();//energy 증가
		petRepository.save(thePet);//database에 저장
		return "잘 잤습니다.";

	}

	//localhost:8080/pets/__/groom, api put
	@RequestMapping(method = RequestMethod.PUT, path="pets/{petId}/groom")
	public String groomPet(@PathVariable(value = "petId") Long petId){

		// //#version 1
		// Cat cat = (Cat)petRepository.findById(petId).get();


		// String i =cat.grooming();
		// petRepository.save(cat);
		// return i;

		// #version 2
		//CrudRepository 내장되어 있는 method findByID 사용
		Pet thepet = petRepository.findById(petId).get();
		if(thepet instanceof Groomable){ // groomable interface를 사용하고 있는 class라면
			String messamge = ((Groomable)thepet).grooming(); 
			petRepository.save(thepet);//database에 저장
			return messamge;
		}
		return "그루밍이 불가능한 펫 입니다.";
	
	}

	//localhost:8080/pets/__/groom, api put
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/groom")
	public String groomCat(@PathVariable(value = "petId") Long petId){

		return groomPet(petId);
	
	}
	//localhost:8080/cats/__/feed, api put
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/feed")
	public String feedCat(@PathVariable(value = "petId") Long petId){


		return feed(petId);

	}
	//localhost:8080/dogs/__/feed, api put
	@RequestMapping(method = RequestMethod.PUT, path="dogs/{petId}/feed")
	public String feedDog(@PathVariable(value = "petId") Long petId){


		return feed(petId);

	}

	//localhost:8080/cats/__/sleep, api put
	@RequestMapping(method = RequestMethod.PUT, path="cats/{petId}/sleep")
	public String sleepCat(@PathVariable(value = "petId") Long petId){


		return sleep(petId);

	}
	//localhost:8080/dogs/__/sleep, api put
	@RequestMapping(method = RequestMethod.PUT, path="dogs/{petId}/sleep")
	public String sleepDog(@PathVariable(value = "petId") Long petId){


		return sleep(petId);

	}





}

