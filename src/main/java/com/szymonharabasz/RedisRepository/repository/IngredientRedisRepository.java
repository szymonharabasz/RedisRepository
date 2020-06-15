package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class IngredientRedisRepository implements IngredientRepository {

    private static final String HASH_NAME = "ingredient";

    private RedisTemplate<String, Ingredient> redisTemplate;
    private HashOperations hashOperations;

    public IngredientRedisRepository() { super(); }

    @Autowired
    private IngredientRedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Ingredient ingredient) {
        hashOperations.put(HASH_NAME, ingredient.getId(), ingredient);
    }

    @Override
    public void update(Ingredient ingredient) {
        hashOperations.put(HASH_NAME, ingredient.getId(), ingredient);
    }

    @Override
    public void deleteIngredient(String id) {
        hashOperations.delete(HASH_NAME, id);
    }

    @Override
    public Ingredient findIngredient(String id) {
        return (Ingredient) hashOperations.get(HASH_NAME, id);
    }
}
