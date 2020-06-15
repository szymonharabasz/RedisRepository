package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.BookSource;

public interface BookSourceRepository {
    void save(BookSource bookSource);
    void update(BookSource bookSource);
    void deleteBookSource(String id);
    BookSource findBookSource(String id);
}
