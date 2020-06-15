package com.szymonharabasz.RedisRepository.rest;

import com.szymonharabasz.RedisRepository.model.BookSource;
import com.szymonharabasz.RedisRepository.repository.BookSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bookSource")
public class BookSourceController {

    @Autowired
    private BookSourceRepository repository;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public BookSource getBookSource(@PathVariable("id") String id) {
        return repository.findBookSource(id);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteBookSource(@PathVariable("id") String id) {
        repository.deleteBookSource(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void updateBookSource(BookSource bookSource) {
        repository.update(bookSource);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createBookSource(@RequestBody BookSource bookSource) {
        repository.save(bookSource);
    }

}
