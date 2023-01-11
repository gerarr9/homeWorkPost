package com.example.workpost.services.Impl;


import com.example.workpost.model.Ingridient;
import com.example.workpost.services.IngridientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngridientImpl implements IngridientService {


    public static int idGenerator = 0;


    public Map<Integer, Ingridient> ingridientMap = new HashMap<>();

    public IngridientImpl() {

    }


    @Override
    public int addIngridient(Ingridient ingridient) {
        int id = idGenerator++;
        ingridientMap.put(id, ingridient);
        return id;
    }

    @Override
    public Ingridient getIngridient(Integer id) {
        return ingridientMap.get(id);
    }
    @Override
    public Ingridient editIngridient(Integer id, Ingridient ingridient){
        if(ingridientMap.containsKey(id)){
        ingridientMap.put(id,ingridient);
        }
        return null;
    }
    @Override
    public  Ingridient deletIngridient(Integer id){
        if (ingridientMap.containsKey(id)){
            return  ingridientMap.remove(id);
        }
        return  null;
    }


}
