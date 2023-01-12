package com.example.workpost.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Ingridient {
    private  String name;
    private  int quantity;
    private String dimension ;
}
