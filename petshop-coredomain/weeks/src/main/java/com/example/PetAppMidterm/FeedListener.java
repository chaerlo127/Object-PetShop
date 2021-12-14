package com.example.PetAppMidterm;


public class FeedListener implements Listener{


    //feedCretreia가 맞지 않는다면 System.out.println을 하게 됨
    //중간고사 code에서만 사용 여기서는 의미 없음
    int feedCreteria = 0;
    
    public FeedListener(int criteria){
        this.feedCreteria = criteria;
    }


    @Override
    public void energyChanged(int energy) {
        if(energy<feedCreteria){
            System.out.println("please feed some food.");
        }
        
    }
    
}
