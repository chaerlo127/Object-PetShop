package com.example.PetAppMidterm;


import com.example.PetAppMidterm.domain.CartItem;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<CartItem>>{

    //localhost:8083/cartItems/pet
    @Override
    public EntityModel<CartItem> process(EntityModel<CartItem> model) {
        model.add(Link.of(model.getContent().getPet()).withRel("pet"));

        return model;
    }
    
}
