package com.szymonharabasz.RedisRepository.rest;

import com.szymonharabasz.RedisRepository.model.WebpageSource;
import com.szymonharabasz.RedisRepository.repository.WebpageSourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/webpageSource")
public class WebpageController {

    @Autowired
    private WebpageSourceRepository repository;

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = "application/json")
    public WebpageSource getWebpageSource(@PathVariable("id") String id) {
        return repository.findWebpageSource(id);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE)
    public void deleteWebpageSource(@PathVariable("id") String id) {
        repository.deleteWebpageSource(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = "application/json")
    public void updateWebpageSource(WebpageSource webpageSource) {
        repository.update(webpageSource);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void createWebpageSource(@RequestBody WebpageSource webpageSource) {
        repository.save(webpageSource);
    }

}
