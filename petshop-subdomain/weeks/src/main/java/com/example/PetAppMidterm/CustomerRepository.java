package com.example.PetAppMidterm;

import com.example.PetAppMidterm.domain.Customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//customer db string으로 저장
@Repository
public interface CustomerRepository  extends CrudRepository <Customer, String>{
    
}
