package org.example.petproj.utils;


import org.example.petproj.entity.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CurrencyConverter {

    @Autowired
    private MyRestClient myRestClient;

    public Material parseCurrencyInMaterial(Material material){
        String currencyName = material.getCurrencyName();
        int price = material.getPrice();
        Double course;
        if(myRestClient.getMatches() != null){
            course = myRestClient.getMatches().get(currencyName);
        } else{
            course = myRestClient.getConnection(DateParser.getLocalDate()).findOnSiteByPattern().get(currencyName);
        }
        material.setRub_price(course * price);//rub price - is price for 1 unit
        return material;
    }

}
