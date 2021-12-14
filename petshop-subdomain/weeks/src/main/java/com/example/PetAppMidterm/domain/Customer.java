package com.example.PetAppMidterm.domain;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//entity 생성
@Entity
@Table //저는 @Table이 없으면 run이 되지 않습니다.
public class Customer {
    @Id
    String id;

    //가독성을 높이기 위해, address안에 있는 값을 밖으로 빼도 되지만, 안에 넣어두고 가독성이 좋게 두는 @Embedded 실행
    @Embedded
    Address address;

    //Getter & Setter 같은 package안에 있는 class가 가능하도록 하는 것은 => protected, 지금은 public
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    

    

    
}
