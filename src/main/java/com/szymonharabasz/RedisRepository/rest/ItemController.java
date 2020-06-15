package com.szymonharabasz.RedisRepository.rest;

import com.szymonharabasz.RedisRepository.model.Item;
import com.szymonharabasz.RedisRepository.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

    @Autowired
    private ItemRepository repository;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public Item getItem(@PathVariable("id") String id) {
        return repository.findItem(id);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") String id) {
        repository.deleteItem(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void updateItem(Item item) {
        repository.update(item);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createItem(@RequestBody Item item) {
        System.out.println(">>> id = " + item.getId() + ", ingredient: " + item.getIngredientId() + ", qty = " + item.getQuantity() + ", unit: " + item.getUnit());
        repository.save(item);
    }

}
