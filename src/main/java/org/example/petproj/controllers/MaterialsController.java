package org.example.petproj.controllers;


import jakarta.validation.Valid;
import org.example.petproj.entity.Material;
import org.example.petproj.service.MaterialsService;
import org.example.petproj.utils.CurrencyConverter;
import org.example.petproj.utils.DateParser;
import org.example.petproj.utils.MyRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/materials")
public class MaterialsController {


    @Autowired
    private MyRestClient myRestClient;

    @Autowired
    private MaterialsService materialsService;


    @Autowired
    private CurrencyConverter currencyConverter;

    private Set<String> currencies;


    @GetMapping("/add-material")
    public String addMaterial(Model model){
        model.addAttribute("material", new Material());
        model.addAttribute("currencies", parseForSelectForm());
        return "AddMaterialPage";
    }

    private Set<String> parseForSelectForm() {
        if(currencies==null) {
            currencies = myRestClient.getConnection(DateParser.getLocalDate()).findOnSiteByPattern().keySet();
        }
        return currencies;
    }

    @PostMapping("/add-material")
    public String addNewMaterialPost(@Valid @ModelAttribute(name = "material") Material material, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("currencies", parseForSelectForm());
            return "AddMaterialPage";
        }

        materialsService.save(currencyConverter.parseCurrencyInMaterial(material));
        return "redirect:/shop/stats";
    }


}
