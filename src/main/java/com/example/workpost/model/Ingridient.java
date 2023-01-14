package com.example.workpost.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingridient {
    private  String name;
    private  int quantity;
    private String dimension ;
}
