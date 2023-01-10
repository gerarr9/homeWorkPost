package com.example.workpost.services.Impl;


import com.example.workpost.model.Recipe;
import com.example.workpost.services.ResipeService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class RecipeImpl implements ResipeService {

    public static int idGeneratod = 0;

    Map<Integer, Recipe> recipeMap = new HashMap<>();
    @Override
    public int addRecipe(Recipe recipe){
        idGeneratod++;
        recipeMap.put(idGeneratod,recipe);
        return  idGeneratod;
    }

    @Override
    public Recipe  getRecipe(Integer id){
        return  recipeMap.get(id);
    }

}
