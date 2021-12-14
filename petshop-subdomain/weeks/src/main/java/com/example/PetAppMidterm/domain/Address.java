package com.example.PetAppMidterm.domain;


import javax.persistence.Embeddable;

//상위 class에는 @Embedded
//하위 클래스에는 @Embeddable
@Embeddable
public class Address {
    //customer -> address안에 zipcode, detail 값 생성
    String zipcode;
    String detail;

    //Getter & Setter
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    

}
