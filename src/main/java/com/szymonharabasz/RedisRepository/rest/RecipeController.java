package com.szymonharabasz.RedisRepository.rest;

import com.szymonharabasz.RedisRepository.model.Recipe;
import com.szymonharabasz.RedisRepository.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/recipe")
public class RecipeController {

    @Autowired
    private RecipeRepository repository;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Recipe getRecipe(@PathVariable("id") String id) {
        return repository.findRecipe(id);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteRecipe(@PathVariable("id") String id) {
        repository.deleteRecipe(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void updateRecipe(Recipe recipe) {
        repository.update(recipe);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createRecipe(@RequestBody Recipe recipe) {
        repository.save(recipe);
    }

}
