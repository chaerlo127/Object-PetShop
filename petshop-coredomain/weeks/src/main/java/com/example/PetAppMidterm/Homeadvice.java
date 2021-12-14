package com.example.PetAppMidterm;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

 
@Component
@Aspect

// UI가 있을 당시에 사용했던 method
//pageView 계산
public class Homeadvice {
    static int pageView = 0;
    public static int getPageView(){
        return ++pageView;
    }

    @After("execution(* com.example.PetAppMidterm.Application.*.*(..))")
    public void after(){
        System.out.println("--- page view : " + (++pageView));
    }
   
}
