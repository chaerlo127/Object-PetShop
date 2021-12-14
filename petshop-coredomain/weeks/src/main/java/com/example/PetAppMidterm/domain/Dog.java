package com.example.PetAppMidterm.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//pet의 name dog으로 @DiscriminatorColumn
//entity 생성
@Entity
@DiscriminatorValue("dog")
public class Dog extends Pet implements Runnable{ //interface : Runnable, parent class: Pet


    //Pet을 상속하하고, Serializable, Runnable을 작성한다
    //Pet: speak() method @override
    //Runnable: run() method @override

    public Dog(){
        setType("Dog");
    }
    
    //speak -> runnable
    @Override
    public void speak() {
        System.out.println("멍멍");
        
    }
    //run -> runnable
    @Override
    public void run() {
        System.out.println("Dog run!!");
        setEnergy(getEnergy()+1);
        
    }

    //잠을 자면 apperance 1 증가 + 부모 class의 sleep method에서 energy 2 증가하는 것 같이 증가
    @Override
    public void sleep(){
       super.sleep();
       setAppearance(getAppearance()+1);
    }
    
}
