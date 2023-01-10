package com.example.workpost.services.Impl;


import com.example.workpost.model.Ingridient;
import com.example.workpost.services.IngridientService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class IngridientImpl implements IngridientService {
  private   String name;
  private   int quantity;
   private String dimension;

   public  static  int idGenerator =0;


  public   Map<Integer, Ingridient> ingridientMap = new HashMap<>();

    public  IngridientImpl(){

    }

    public IngridientImpl(String name, int quantity, String dimension) {
        this.name = name;
        this.quantity = quantity;
        this.dimension = dimension;
    }
@Override
    public  int   addIngridient(Ingridient ingridient){
        int id = idGenerator++;
        ingridientMap.put(id,ingridient);
        return id;
    }

    @Override
     public Ingridient getIngridient(Integer id){
       return ingridientMap.get(id);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getQuantity() {
        return this.quantity;
    }

    @Override
    public String getDimension() {
        return this.dimension;
    }

    @Override
    public String toString() {
        return "Продукт: "+ getName()+", количество "+ getQuantity() +" "+getDimension();
    }
}
