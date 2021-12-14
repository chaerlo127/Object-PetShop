package com.example.PetAppMidterm;


import com.example.PetAppMidterm.domain.Dog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//dog database
@Repository
public interface DogRepository extends CrudRepository<Dog, Long>{//Repository Pattern Interface
    
    // Pet save(Pet pet) throws Exception; //create
    // Pet delete(Pet pet) throws Exception;  //delete
    // List<Pet> findAll() throws Exception;//read;
    // Pet update(Pet pet) throws Exception;//update
}
