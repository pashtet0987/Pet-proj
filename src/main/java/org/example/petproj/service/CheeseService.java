package org.example.petproj.service;

import org.example.petproj.dao.CheeseDAO;
import org.example.petproj.entity.Cheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CheeseService {

    @Autowired
    private CheeseDAO cheeseDAO;

    public void addCheese(Cheese cheese){
        cheeseDAO.save(cheese);
    }

    public Cheese getCheeseByName(String name){
        return cheeseDAO.findByCheeseName(name);
    }


    public List<Cheese> getAllCheese(){
        return cheeseDAO.findAll();
    }

    public void deleteCheese(Cheese cheese){
        cheeseDAO.delete(cheese);
    }

    public Set<String> getCheeseNames(){
        Set<String> cheeseNames = new HashSet<>();
        for(Cheese cheese: getAllCheese()){
            cheeseNames.add(cheese.getCheeseName());
        }
        return cheeseNames;
    }

    public List<Cheese> getAllByCheeseNameOrderById(String cheeseName){
        return cheeseDAO.findAllByCheeseNameOrderById(cheeseName);
    }
}
