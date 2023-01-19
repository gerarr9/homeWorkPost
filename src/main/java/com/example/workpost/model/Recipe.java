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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name).append("\n")
                .append(time).append(" минут").append("\n");
        return stringBuilder.toString();

    }
}
