package com.example.workpost.services;

import com.example.workpost.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface ResipeService {
    int addRecipe(Recipe recipe);


    Recipe  getRecipe(Integer id);
}
