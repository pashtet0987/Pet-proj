package org.example.petproj.controllers;


import org.example.petproj.entity.Cheese;
import org.example.petproj.entity.Material;
import org.example.petproj.entity.Sells;
import org.example.petproj.service.CheeseService;
import org.example.petproj.service.MaterialsService;
import org.example.petproj.service.SellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class MainPageController {

    @Autowired
    private CheeseService cheeseService;

    @Autowired
    private MaterialsService materialsService;

    @Autowired
    private SellsService sellsService;

    @GetMapping("/stats")
    public String cheeseFabric(Model model){
        List<Cheese> cheese = cheeseService.getAllCheese();
        model.addAttribute("cheese", cheese);

        List<Material> materials = materialsService.getAllMaterials();
        model.addAttribute("materials", materials);

        List<Sells> sells = sellsService.getAllSells();
        model.addAttribute("sells", sells);


        return "MainPage";
    }


    @GetMapping("/add-cheese")
    public RedirectView produceCheese(){
        return new RedirectView("/cheese/add-cheese");
    }

    @GetMapping("/add-material")
    public RedirectView buyMaterial(){
        return new RedirectView("/materials/add-material");
    }

    @GetMapping("/add-sell")
    public RedirectView sell(){
        return new RedirectView("/sells/add-sell");
    }

    @GetMapping("/observe-recipes")
    public RedirectView observeRecipes(){
        return new RedirectView("/recipes/observe-recipes");
    }
}
