package com.example.PetAppMidterm;

import org.springframework.stereotype.Repository;

import com.example.PetAppMidterm.domain.CartItem;

import org.springframework.data.repository.CrudRepository;
//cartItem db long 으로 저장
@Repository
public interface CartRepository extends CrudRepository <CartItem, Long>{
    
}