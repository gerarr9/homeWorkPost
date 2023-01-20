package com.example.workpost.services.Impl;


import com.example.workpost.model.Ingridient;
import com.example.workpost.services.FilesServise;
import com.example.workpost.services.IngridientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;

@Service
public class IngridientIServiceImpl implements IngridientService {

    final private FilesServise filesServise;
    public static int idGenerator = 0;


    public Map<Integer, Ingridient> ingridientMap = new HashMap<>();


    public IngridientIServiceImpl(FilesServise filesServise) {

        this.filesServise = filesServise;
    }


    @Override
    public int addIngridient(Ingridient ingridient) {
        int id = idGenerator++;
        ingridientMap.put(id, ingridient);
        saveToFile();
        return id;
    }

    @Override
    public Ingridient getIngridient(Integer id) {
        return ingridientMap.get(id);
    }

    @Override
    public Ingridient editIngridient(Integer id, Ingridient ingridient) {
        if (ingridientMap.containsKey(id)) {
            ingridientMap.put(id, ingridient);
            saveToFile();
        }

        return null;
    }

    @Override
    public Ingridient deletIngridient(Integer id) {
        if (ingridientMap.containsKey(id)) {
            return ingridientMap.remove(id);
        }
        return null;
    }

    private void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingridientMap);
            filesServise.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private void readToFile() {
        String json = filesServise.readFromFile();
        try {
            ingridientMap = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Ingridient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
