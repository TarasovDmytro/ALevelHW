package services;

import models.Visit;

import java.util.List;

public class VisitService {

    public Visit postVisit(String name, String date, String city){
        return Visit.Build()
                .setName(name)
                .setDate(date)
                .setCity(city)
                .createVisit();
    }

    public List<Visit> getVisits(){
        return Visit.getVisits();
    }


}
