package org.example.petproj.controllers;


import jakarta.validation.Valid;
import org.example.petproj.entity.Sells;
import org.example.petproj.service.CheeseService;
import org.example.petproj.service.SellsService;
import org.example.petproj.utils.SellCheese;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sells")
public class SellsController {

    @Autowired
    private SellsService sellsService;

    @Autowired
    private CheeseService cheeseService;

    @Autowired
    private SellCheese sellCheese;

    @GetMapping("/add-sell")
    public String addSell(Model model){
        model.addAttribute("cheeseNames", cheeseService.getCheeseNames());
        model.addAttribute("sell", new Sells());
        return "AddSellsPage";
    }

    @PostMapping("/add-sell")
    public String sellAdded(@Valid @ModelAttribute("sell") Sells sells, BindingResult bindingResult, Model model){
        double fullPrice;
        if(bindingResult.hasErrors()|| (fullPrice = sellCheese.sellCheese(sells.getCheeseName(), sells.getAmountOfSells()))==0D){
            model.addAttribute("cheeseNames", cheeseService.getCheeseNames());
            return "AddSellsPage";
        }
        sells.setPrice(fullPrice);
        sellsService.saveSells(sells);
        return "redirect:/shop/stats";
    }
}
