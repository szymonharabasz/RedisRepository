package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.BookSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class BookSourceRedisRepository implements BookSourceRepository {

    private static final String HASH_NAME = "bookSource";

    private RedisTemplate<String, BookSource> redisTemplate;
    private HashOperations hashOperations;

    public BookSourceRedisRepository() { super(); }

    @Autowired
    private BookSourceRedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(BookSource bookSource) {
        hashOperations.put(HASH_NAME, bookSource.getId(), bookSource);
    }

    @Override
    public void update(BookSource bookSource) {
        hashOperations.put(HASH_NAME, bookSource.getId(), bookSource);
    }

    @Override
    public void deleteBookSource(String id) {
        hashOperations.delete(HASH_NAME, id);
    }

    @Override
    public BookSource findBookSource(String id) {
        return (BookSource) hashOperations.get(HASH_NAME, id);
    }
}
