package com.example.workpost.services;


import com.example.workpost.model.Recipe;

import java.util.Map;

public interface ResipeService {
    int addRecipe(Recipe recipe);


    Recipe  getRecipe(Integer id);
}
