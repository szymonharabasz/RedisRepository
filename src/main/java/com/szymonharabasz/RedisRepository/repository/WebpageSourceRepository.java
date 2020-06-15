package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.WebpageSource;

public interface WebpageSourceRepository {
    void save(WebpageSource webpageSource);
    void update(WebpageSource webpageSource);
    void deleteWebpageSource(String id);
    WebpageSource findWebpageSource(String id);
}
