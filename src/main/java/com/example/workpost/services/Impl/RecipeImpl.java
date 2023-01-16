package com.example.workpost.services.Impl;


import com.example.workpost.model.Ingridient;
import com.example.workpost.model.Recipe;
import com.example.workpost.services.FilesServise;
import com.example.workpost.services.ResipeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecipeImpl implements ResipeService {
    final private FilesServise filesServise;

    public static int idGeneratod = 0;

    Map<Integer, Recipe> recipeMap = new HashMap<>();

    public RecipeImpl(FilesServise filesServise) {
        this.filesServise = filesServise;
    }

    @Override
    public int addRecipe(Recipe recipe) {
        int id = idGeneratod++;
        recipeMap.put(idGeneratod, recipe);
        saveToRecipe();
        return id;
    }

    @Override
    public Recipe getRecipe(Integer id) {
        return recipeMap.get(id);
    }

    @Override
    public Recipe editRecipe(Integer id, Recipe recipe) {
        if (recipeMap.containsKey(id)) {
            recipeMap.put(id, recipe);
            saveToRecipe();

        }
        return null;
    }

    @Override
    public Recipe deletRecipe(Integer id) {
        if (recipeMap.containsKey(id)) {
            return recipeMap.remove(id);
        }
        return null;
    }

    private void saveToRecipe() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipeMap);
            filesServise.saveToRecipe(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readToFile() {
        String json = filesServise.readFromRecipe();
        try {
            recipeMap = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Recipe>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
