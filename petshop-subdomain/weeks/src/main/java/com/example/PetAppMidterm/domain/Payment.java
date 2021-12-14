package com.example.PetAppMidterm.domain;

import javax.persistence.Embeddable;

//상위 class에는 @Embedded
//하위 클래스에는 @Embeddable
@Embeddable
public class Payment {
    //CartItem -> Payment안에 method, status 값 생성
    String method;
    String status;

    //Getter & Setter
    public String getMethod() {
        return method;
    }
    public void setMethod(String method) {
        this.method = method;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
