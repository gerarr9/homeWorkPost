package com.example.workpost.services;

public interface FilesServise {
    boolean saveToFile(String json);

    String readFromFile();

    boolean saveToRecipe(String json);

    String readFromRecipe();
}
