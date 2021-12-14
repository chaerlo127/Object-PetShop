package com.example.PetAppMidterm;


import com.example.PetAppMidterm.domain.Cat;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//cat database
@Repository
public interface CatRepository extends CrudRepository<Cat, Long>{//Repository Pattern Interface
    
    // Pet save(Pet pet) throws Exception; //create
    // Pet delete(Pet pet) throws Exception;  //delete
    // List<Pet> findAll() throws Exception;//read;
    // Pet update(Pet pet) throws Exception;//update
}
