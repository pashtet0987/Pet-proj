package org.example.petproj.service;


import org.example.petproj.dao.SellsDAO;
import org.example.petproj.entity.Sells;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellsService {

    private final SellsDAO sellsDAO;

    public SellsService(SellsDAO sellsDAO) {
        this.sellsDAO = sellsDAO;
    }


    public List<Sells> getAllSells(){
        return sellsDAO.findAll();
    }

    public void saveSells(Sells sells){
        sellsDAO.save(sells);
    }
}
