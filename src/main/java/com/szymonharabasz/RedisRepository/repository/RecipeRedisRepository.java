package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class RecipeRedisRepository implements RecipeRepository {

    private static final String HASH_NAME = "recipe";

    private RedisTemplate<String, Recipe> redisTemplate;
    private HashOperations hashOperations;

    public RecipeRedisRepository() { super(); }

    @Autowired
    private RecipeRedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Recipe recipe) {
        hashOperations.put(HASH_NAME, recipe.getId(), recipe);
    }

    @Override
    public void update(Recipe recipe) {
        hashOperations.put(HASH_NAME, recipe.getId(), recipe);
    }

    @Override
    public void deleteRecipe(String id) {
        hashOperations.delete(HASH_NAME, id);
    }

    @Override
    public Recipe findRecipe(String id) {
        return (Recipe) hashOperations.get(HASH_NAME, id);
    }
}
