package org.example.petproj.service;



import org.example.petproj.dao.RecipeDAO;
import org.example.petproj.entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RecipeService {

    @Autowired
    private RecipeDAO recipeDAO;

    public void save(Recipe recipe) {
        recipeDAO.save(recipe);
    }

    public List<Recipe> findAll(){return recipeDAO.findAll();}

    public Set<String> getAvailibleRecipesNames() {
        Set<String> names = new HashSet<>();
        for(Recipe recipe: findAll()){
            names.add(recipe.getCheeseName());
        }
        return names;
    }

    public List<Recipe> findAllByCheeseName(String cheeseName){
        return recipeDAO.findAllByCheeseName(cheeseName);
    }

    public void delete(Recipe recipe){
        recipeDAO.delete(recipe);
    }
}
