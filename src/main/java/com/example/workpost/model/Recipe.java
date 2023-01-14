package com.example.workpost.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private  int time;
    private  Ingridient ingridient;
    private  String steps;

}
