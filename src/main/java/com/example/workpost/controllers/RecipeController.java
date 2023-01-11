package com.example.workpost.controllers;


import com.example.workpost.model.Recipe;
import com.example.workpost.services.ResipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/recipe")
public class RecipeController {
    private ResipeService recipes;

    public RecipeController(ResipeService recipes) {
        this.recipes = recipes;
    }

    @PostMapping()
    public ResponseEntity<Integer>addRecipe(@RequestBody Recipe recipe){
        int id =  recipes.addRecipe(recipe);
        return  ResponseEntity.ok(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Recipe> recipetList(@PathVariable Integer id){
        Recipe recipe =  recipes.getRecipe(id);
        return  ResponseEntity.ok(recipe);
    }
}
