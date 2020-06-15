package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.Recipe;

public interface RecipeRepository {
    void save(Recipe recipe);
    void update(Recipe recipe);
    void deleteRecipe(String id);
    Recipe findRecipe(String id);
}
