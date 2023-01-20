package com.example.workpost.services.Impl;

import com.example.workpost.services.FilesServise;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class FilesServiseImpl implements FilesServise {
    @Value("${path.to.data.file}")
    private String dataFilePath;

    @Value("${name.of.data.file}")
    private String dataFileName;
    @Value("${path.to.recipe.file}")
    private  String recipeFilePath;
    @Value("${name.of.recipe.file}")
    private  String recipeFileName;
    @Override
    public boolean saveToFile(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(dataFilePath,dataFileName),json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(dataFilePath,dataFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean cleanDataFile() {
        try {
            Path path = Path.of(dataFilePath,dataFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean saveToRecipe(String json) {
        try {
            cleanRecipeFile();
            Files.writeString(Path.of(recipeFilePath,recipeFileName),json);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    @Override
    public String readFromRecipe(){
        try {
            return  Files.readString(Path.of(recipeFilePath,recipeFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public   boolean cleanRecipeFile(){
        try {
            Path path = Path.of(recipeFilePath,recipeFileName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return  true;
        } catch (IOException e) {
            e.printStackTrace();
            return  false;
        }

    }
    @Override
    public File getDataFile(){
        return  new  File(dataFilePath + "/" + dataFileName);
    }
    @Override
    public  File getRecipeFile(){
        return  new  File (recipeFilePath +"/"+recipeFileName);
    }
    @Override
    public Path createTempFile(String suffix) {
        try {
            return Files.createTempFile(Path.of(dataFilePath), "tenpfile", suffix);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
