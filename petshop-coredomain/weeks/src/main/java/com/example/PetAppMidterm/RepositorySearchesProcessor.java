package com.example.PetAppMidterm;

import com.example.PetAppMidterm.domain.Cat;
import com.example.PetAppMidterm.domain.Pet;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class RepositorySearchesProcessor implements RepresentationModelProcessor<EntityModel<Pet>>{

    @Override
    public EntityModel<Pet> process(EntityModel<Pet> model) {
        //localhost:8080//cats OR dogs/feed
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/feed").withRel("feed"));
        /*기존 코드에서 추가한 부분
          feed, groom 이외에 Sleep 부분을 추가해줌
        */
        //localhost:8080//cats OR dogs/sleep
        model.add(Link.of(model.getRequiredLink("self").getHref() + "/sleep").withRel("sleep"));
        if(model.getContent() instanceof Cat){
            //localhost:8080//cats/feed -> Cat.java 내부에 있다면
            model.add(Link.of(model.getRequiredLink("self").getHref() + "/groom").withRel("groom"));
        }

        return model;
    }
    
}
