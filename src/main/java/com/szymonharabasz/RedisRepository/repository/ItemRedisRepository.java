package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class ItemRedisRepository implements ItemRepository {

    private static final String HASH_NAME = "item";

    private RedisTemplate<String, Item> redisTemplate;
    private HashOperations hashOperations;

    public ItemRedisRepository() { super(); }

    @Autowired
    private ItemRedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Item item) {
        hashOperations.put(HASH_NAME, item.getId(), item);
    }

    @Override
    public void update(Item item) {
        hashOperations.put(HASH_NAME, item.getId(), item);
    }

    @Override
    public void deleteItem(String id) {
        hashOperations.delete(HASH_NAME, id);
    }

    @Override
    public Item findItem(String id) {
        return (Item) hashOperations.get(HASH_NAME, id);
    }
}
