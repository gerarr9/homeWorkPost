package com.example.workpost.services;



import com.example.workpost.model.Ingridient;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;



public interface IngridientService {


    int   addIngridient(Ingridient ingridient);

    Ingridient getIngridient(Integer id);

    String getName();
    int getQuantity();
    String getDimension();
}
