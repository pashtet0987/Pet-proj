package org.example.petproj.utils;


import org.example.petproj.entity.Material;
import org.example.petproj.entity.Recipe;
import org.example.petproj.service.MaterialsService;
import org.example.petproj.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CheeseFromMaterials {

    @Autowired
    private MaterialsService materialsService;

    @Autowired
    private RecipeService recipeService;
    private Map<String, Integer> getRecipeByCheeseName(String name, int amount){
        List<Recipe> recipes = recipeService.findAllByCheeseName(name);
        Map<String, Integer> materialsRequired = new HashMap<>();
        for(Recipe recipe: recipes){
            materialsRequired.put(recipe.getMaterialName(), recipe.getAmountOfMaterialRequired()*amount);
        }
        return materialsRequired;
    }


//    Берем рецепт, для каждого материала берем запись из бд и вычитаем возможное
//    количество и добавляем в лист для последующего удаления, иначе уменьшаем
//    количество материалов на складе и сохраняем, также накапливаем сумму стоимости
//    всех произведенных сыров. Если невозможно произвести сыр ввиду отсутствия нужного
//    количества материалов, вернется 0 значение переменной allCheesePrice,
//    иначе вернется значение цены 1 головки сыра, вычисленное путем деления значения переменной
//    на количество производимых сыров.
    public double produceCheeseFromMaterials(String cheeseName, int amount){
        Map<String, Integer> materialsRequired = getRecipeByCheeseName(cheeseName, amount);
        int amountLeft;
        double allCheesePrice = 0D;
        for(Map.Entry<String, Integer> entry: materialsRequired.entrySet()){
            List<Material> materials = materialsService.getMaterialsByNameOrderById(entry.getKey());
            List<Material> toDelete = new ArrayList<>();
            for(Material material: materials){
                if(entry.getValue()>0) {
                    if (material.getAmount() <= entry.getValue()) {
                        entry.setValue(entry.getValue() - material.getAmount());
                        toDelete.add(material);
                        //сдесь
                    }else{
                        allCheesePrice+= material.getRub_price()*(entry.getValue());//суммируем цену для всех произведенных сыров
                        material.setAmount(material.getAmount() - entry.getValue());//оставшееся количество материала
                        materialsService.save(material);
                        entry.setValue(0);
                        //и сдесь устанавливается цена сыра
                    }
                }
            }
            amountLeft = entry.getValue();
            if(amountLeft>0){
                return 0D;
            }else{
                for(Material material: toDelete){
                    allCheesePrice+=material.getRub_price()*material.getAmount();
                    materialsService.delete(material);
                }
            }
        }
        return allCheesePrice/amount;
    }

}
