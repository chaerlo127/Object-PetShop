package com.example.PetAppMidterm;


import com.example.PetAppMidterm.domain.Pet;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//pet database
@Repository
public interface PetRepository extends CrudRepository<Pet, Long>{//Repository Pattern Interface

    // Pet save(Pet pet) throws Exception; //create
    // Pet delete(Pet pet) throws Exception;  //delete
    // List<Pet> findAll() throws Exception;//read;
    // Pet update(Pet pet) throws Exception;//update
}
