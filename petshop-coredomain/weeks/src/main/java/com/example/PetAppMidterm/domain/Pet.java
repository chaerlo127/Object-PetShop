package com.example.PetAppMidterm.domain;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//entity 생성
@Table
@Entity
//column 상세 설명
@DiscriminatorColumn(
    discriminatorType = DiscriminatorType.STRING,//string 값
    name = "pet_type",//Dog or Cat
    columnDefinition = "CHAR(5)"
)

public abstract class Pet {   //Entity, Domain class(전문성, 주요한 객체들, 환경이 변해도 영향을 받지 않는 class)
    //이 외에도, pet, cat, dog, grommable이 있음
    //나머지는 구현 class


    
   //id
    @Id @GeneratedValue
    Long id;
    public Long getId() {
        return id;
    }



    //name -> pet name, Getter & Setter
    String name;
        public String getName() {
            return name;
        }


        //name은 null 값이면 안됨, sql ex> name varchar2(4) not null,
        public void setName(String name) {
            if(name == null)  throw new IllegalArgumentException("이름은 꼭 들어가야 합니다.");


            this.name = name;
        }

    //Getter & Setter, type
    String type;
        public String getType() {
            return type;
        }


        public void setType(String type) {
            this.type = type;
        }


    abstract public void speak();

    //appearance 부분 추가
    private int appearance =0;//apperance attribute 추가
        public int getAppearance() {//getter
            return appearance;
        }


        protected void setAppearance(int appearance) {//setter
            if(Math.abs(this.appearance - appearance) <11){// 오류문 설정
                this.appearance = appearance;
            }
            else {
                throw new IllegalArgumentException("appearance change is too big");//크면 오류문 return
            }
        }
    //energy 부분 추가
    private int energy = 0;//apperance attribute 추가
        public int getEnergy() {//getter
            return energy;
        }

        
        protected void setEnergy(int energy) {//setter
            if(Math.abs(this.energy - energy) <11){// 오류문 설정
                this.energy = energy;
            }
            else {
                throw new IllegalArgumentException("Energy change is too big");//크면 오류문 return
            }
        }

    //energy 2 증가 -> frontend에 ui로 보이게 됨
    public void eat(){
        energy +=2;
        // check();
    }


    //energy 2 증가 -> frontend에 ui로 보이게 됨
    public void sleep(){
        energy +=2;

        // check();
       
    }

  
   

   
    @Override
    public String toString(){
        return "<a href='./" + this.getClass().getSimpleName().toLowerCase()+"'"+">" +this.getClass().getSimpleName() + "</a>";
    }
    // public void check(){
    //     if(listeners!=null){
    //         for(int i=0; i<listeners.size();i++){
    //             listeners.get(i).energyChanged(energy);
    //         }
    //     }
    // }

}
