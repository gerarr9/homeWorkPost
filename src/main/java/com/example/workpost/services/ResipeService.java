package com.example.workpost.services;

import com.example.workpost.model.Recipe;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public interface ResipeService {
    int addRecipe(Recipe recipe);


    Recipe  getRecipe(Integer id);

    Recipe editRecipe(Integer id, Recipe recipe);

    Recipe deletRecipe(Integer id);

    Path CreateRecipeTextFileAll() throws IOException;
}
