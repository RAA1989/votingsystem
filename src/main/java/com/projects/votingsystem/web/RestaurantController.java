package com.projects.votingsystem.web;

import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static com.projects.votingsystem.web.RestaurantController.URL;

@RestController
@RequestMapping(value = URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantController {
    static final String URL = "/restaurants";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    RestaurantService service;

    @GetMapping
    public List<Restaurant> getAllWithLastMenu(){
        log.info("get restaurants with menu");
        return service.getAllWithLastMenu();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> createWithLocation(@Valid @RequestBody Restaurant restaurant){
        log.info("create a restaurant");
        Restaurant created = service.create(restaurant);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping(value = "/all")
    public List<Restaurant> getAll(){
        log.info("get all restaurants");
        return service.getAll();
    }
}
