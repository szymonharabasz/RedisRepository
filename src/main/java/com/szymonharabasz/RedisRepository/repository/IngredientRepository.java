package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.Ingredient;

public interface IngredientRepository {
    void save(Ingredient item);
    void update(Ingredient item);
    void deleteIngredient(String id);
    Ingredient findIngredient(String id);
}
