package com.example.workpost.services;



import com.example.workpost.model.Ingridient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;



public interface IngridientService {


    int   addIngridient(Ingridient ingridient);

    Ingridient getIngridient(Integer id);


    Ingridient editIngridient(Integer id, Ingridient ingridient);

    Ingridient deletIngridient(Integer id);
}
