package com.example.PetAppMidterm.domain;



import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.example.PetAppMidterm.Groomable;

//pet의 name cat으로 @DiscriminatorColumn
//entity 생성
@Entity
@DiscriminatorValue("cat")
public class Cat extends Pet implements Groomable, Runnable{ //interface : Groomable, Runnable, parent class: Pet


    // @DiscriminatorColumn.type -> cat
    public Cat(){
       setType("Cat");
    }
    
   //speak
    @Override
    public void speak() {
        if(getEnergy()<5){
            System.out.println("I'm hungry");
        }        
        else System.out.println("HI");
    }

    //run
    @Override
    public void run() {
        System.out.println("I'm running!");
    }

    //groomable interface 사용
    @Override
    public String grooming() {
    //apperance 1 추가
    setAppearance(getAppearance() + 1);//apperance 1 추가, 직접 추가하지 못하기 때문에 Setter와 getter이용

    return "야옹, 행복하다 집사야";
    }
    
}
