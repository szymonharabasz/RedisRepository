package com.szymonharabasz.RedisRepository.repository;

import com.szymonharabasz.RedisRepository.model.Item;

public interface ItemRepository {
    void save(Item item);
    void update(Item item);
    void deleteItem(String id);
    Item findItem(String id);
}
