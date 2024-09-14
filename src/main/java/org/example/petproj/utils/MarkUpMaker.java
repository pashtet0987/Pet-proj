package org.example.petproj.utils;

import org.springframework.stereotype.Component;

@Component
public class MarkUpMaker {
    public Double makeMarkup(double price, int markup){
        return (price*(100+markup))/100;
    }
}
