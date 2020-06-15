package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.WebpageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class WebpageSourceRedisRepository implements WebpageSourceRepository {

    private static final String HASH_NAME = "webpageSource";

    private RedisTemplate<String, WebpageSource> redisTemplate;
    private HashOperations hashOperations;

    public WebpageSourceRedisRepository() { super(); }

    @Autowired
    private WebpageSourceRedisRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init() {
        this.hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(WebpageSource webpageSource) {
        hashOperations.put(HASH_NAME, webpageSource.getId(), webpageSource);
    }

    @Override
    public void update(WebpageSource webpageSource) {
        hashOperations.put(HASH_NAME, webpageSource.getId(), webpageSource);
    }

    @Override
    public void deleteWebpageSource(String id) {
        hashOperations.delete(HASH_NAME, id);
    }

    @Override
    public WebpageSource findWebpageSource(String id) {
        return (WebpageSource) hashOperations.get(HASH_NAME, id);
    }
}
