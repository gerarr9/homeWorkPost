package com.example.workpost.controllers;


import com.example.workpost.model.Ingridient;
import com.example.workpost.services.FilesServise;
import com.example.workpost.services.IngridientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/ingridients")
@Tag(name="Ингридиенты", description = "Добавление,удаление,получение, изменение ингридиентов")
public class IngridientConsolle {

    private IngridientService ingridients;


    public IngridientConsolle(IngridientService ingridients) {
        this.ingridients = ingridients;
    }

    @PostMapping()
    @Operation(
            summary = "Добовление ингридиентов",
            description = "Можно добовлять ингридиенты,количество и еденицу измерения"
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

    public ResponseEntity<Integer> addProduct(@RequestBody Ingridient ingridient){
        int id = ingridients.addIngridient(ingridient);
        return  ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Получение ингридиента",
            description = "Можно получить ингридиенты,количество и еденицу измерения"
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
    public ResponseEntity<Ingridient> ingridientList(@PathVariable Integer id){
      Ingridient ingridient =  ingridients.getIngridient(id);
      return  ResponseEntity.ok(ingridient);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Изминение ингридиента",
            description = "Можно изменять ингридиенты,количество и еденицу измерения"
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
    public  ResponseEntity<Ingridient> ingridientEntity(@PathVariable int id ,@RequestBody Ingridient ingridient){
        Ingridient ingridient1 = ingridients.editIngridient(id,ingridient);
        return  ResponseEntity.ok(ingridient1);
    }
    @DeleteMapping("/{id}")
    @Operation(
            summary = "Удалить ингридиент",
            description = "Можно удалить ингридиенты,количество и еденицу измерения"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Все работает",
                    content = {
                            @Content(mediaType = "json")
            }
            )
    }
    )
    public  ResponseEntity ingridientDelet(@PathVariable int id ){
        Ingridient ingridient1 = ingridients.deletIngridient(id);
        return  ResponseEntity.ok(ingridient1);
    }
}
