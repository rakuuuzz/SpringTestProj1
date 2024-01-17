package ru.appline.springtest2.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PetModel implements Serializable {
    private static final PetModel instance = new PetModel();

    private final Map<Integer, Pet> model;

    public PetModel() {
        model = new HashMap<Integer, Pet>();
    }

    public static PetModel getInstance() {
        return instance;
    }

    public void add(Pet pet, int id) {
        model.put(id,pet);
    }

    public void del(int id) { model.remove(id); }

    public void put(Pet updpet, int id) {
        Pet pet = model.get(id);
        pet.setName(updpet.getName());
        pet.setType(updpet.getType());
        pet.setAge(updpet.getAge());
        model.put(id,pet);
    }

    public Pet getFromList(int id) {
        return model.get(id);
    }

    public Map<Integer,Pet> getAll() {
        return model;
    }

    public int getSize(int id) { return id;}
}
