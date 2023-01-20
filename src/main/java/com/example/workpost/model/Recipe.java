package com.example.workpost.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private String name;
    private int time;
    private Ingridient ingridient;
    private String steps;

    @Override
    public String toString() {
        return "\n" +
                name + '\n' +
                "Время приготовления: " + time+ " " + "\n" +
                "Ингредиенты: " + "\n" + ingridient + "\n" +
                "Инструкция приготовления: " + steps + "\n";
    }
}
