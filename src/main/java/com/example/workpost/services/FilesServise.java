package com.example.workpost.services;

import java.io.File;

public interface FilesServise {
    boolean saveToFile(String json);

    String readFromFile();

    boolean cleanDataFile();

    boolean saveToRecipe(String json);

    String readFromRecipe();

    boolean cleanRecipeFile();

    File getDataFile();

    File getRecipeFile();
}
