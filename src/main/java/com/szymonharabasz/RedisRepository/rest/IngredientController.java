package com.szymonharabasz.RedisRepository.rest;

import com.szymonharabasz.RedisRepository.model.Ingredient;
import com.szymonharabasz.RedisRepository.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ingredient")
public class IngredientController {

    @Autowired
    private IngredientRepository repository;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Ingredient getIngredient(@PathVariable("id") String id) {
        return repository.findIngredient(id);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteIngredient(@PathVariable("id") String id) {
        repository.deleteIngredient(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void updateIngredient(Ingredient ingredient) {
        repository.update(ingredient);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createIngredient(@RequestBody Ingredient ingredient) {
        repository.save(ingredient);
    }

}
