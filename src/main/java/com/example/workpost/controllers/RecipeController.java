package com.example.workpost.controllers;


import com.example.workpost.model.Recipe;
import com.example.workpost.services.ResipeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController()
@RequestMapping("/recipe")
@Tag(name = "Рецепты",description = "Добавление,удаление,получение, изменение рецептов")
public class RecipeController {
    private ResipeService recipes;

    public RecipeController(ResipeService recipes) {
        this.recipes = recipes;
    }

    @PostMapping()
    @Operation(
            summary = "Добовление рецептов",
            description = "Можно добовлять рецепты,количество и еденицу измерения"
    )
    @ApiResponses(value = {
            @ApiResponse(

                    responseCode = "200",
                    description = "Все работает",
                    content = {
                            @Content(
                                    mediaType = "json"
                            )
                    }
            )
    })
    public ResponseEntity<Integer>addRecipe(@RequestBody Recipe recipe){
        int id =  recipes.addRecipe(recipe);
        return  ResponseEntity.ok(id);
    }
    @GetMapping("/{id}")
    @Operation(
            summary = "Получение рецепты",
            description = "Можно получать рецепты,количество и еденицу измерения"
    )
    @ApiResponses(value = {
            @ApiResponse(

                    responseCode = "200",
                    description = "Все работает",
                    content = {
                            @Content(
                                    mediaType = "json"
                            )
                    }
            )
    })
    public ResponseEntity<Recipe> recipetList(@PathVariable Integer id){
        Recipe recipe =  recipes.getRecipe(id);
        return  ResponseEntity.ok(recipe);
    }
    @GetMapping("/download/all")
    public  ResponseEntity downloadAllRecipes() {
        try {
            Path path =recipes.CreateRecipeTextFileAll();
            InputStreamResource inputStream = new InputStreamResource(new FileInputStream(path.toFile()));
            return ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"AllRecipes.doc\"")
                    .contentLength(Files.size(path))
                    .body(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    @PutMapping("/{id}")
    @Operation(
            summary = "Изминение рецептов",
            description = "Можно изменять рецепты,количество и еденицу измерения"
    )
    @ApiResponses(value = {
            @ApiResponse(

                    responseCode = "200",
                    description = "Все работает",
                    content = {
                            @Content(
                                    mediaType = "json"
                            )
                    }
            )
    })
    public ResponseEntity<Recipe> editREcipe(@PathVariable int id,@RequestBody Recipe recipe){
        Recipe recipe1 = recipes.editRecipe(id,recipe);
        return  ResponseEntity.ok(recipe);
    }
    @DeleteMapping("/{id}")
    public  ResponseEntity recipeDelet(@PathVariable int id){
        Recipe recipe = recipes.deletRecipe(id);
        return ResponseEntity.ok(recipe);
    }
}
