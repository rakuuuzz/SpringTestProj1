package ru.appline.springtest2.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.appline.springtest2.logic.Pet;
import ru.appline.springtest2.logic.PetModel;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controller {
    private static final PetModel petModel = PetModel.getInstance();
    private static final AtomicInteger newId = new AtomicInteger(1);

    @PostMapping(value = "/createPet", consumes = "application/json")
    public ResponseEntity<String> createPet(@RequestBody Pet pet ) {
        petModel.add(pet,newId.getAndIncrement());
        return ResponseEntity.status(HttpStatus.OK).body("Питомец создан");
    }

    @GetMapping(value = "/getAll", produces = "application/json")
    public Map<Integer, Pet> getAll() {
        return petModel.getAll();
    }

    @GetMapping(value = "/getPet", consumes = "application/json", produces = "application/json")
    public Pet getPet(@RequestBody Map<String,Integer> id) {
        return petModel.getFromList(id.get("id"));
    }

    @DeleteMapping(value = "/deletePet")
    public void delPet(@RequestBody Map<String,Integer> id) {
        petModel.del(id.get("id"));
    }

    @PutMapping(value = "/putPet/{id}", consumes = "application/json", produces = "application/json" )
    public void putPet(@PathVariable int id, @RequestBody Pet updatedPet) {
        petModel.put(updatedPet,id);
    }
}
