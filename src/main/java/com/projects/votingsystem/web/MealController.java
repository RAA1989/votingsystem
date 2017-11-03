package com.projects.votingsystem.web;


import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.service.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;

import static com.projects.votingsystem.util.ValidationUtil.assureIdConsistent;
import static com.projects.votingsystem.web.MealController.URL;

@RestController
@RequestMapping(value = URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController {
    static final String URL = "/meals";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MealService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createWithLocation(@RequestBody Meal meal, @RequestParam(value = "menuId") int menuId){
        log.info("create meal");
        Meal created = service.create(meal, menuId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(meal.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Meal update(@RequestBody Meal meal, @PathVariable("id") int id){
        log.info("update meal");
        assureIdConsistent(meal, id);
        return service.update(meal);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        log.info("delete meal");
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Meal get(@PathVariable("id") int id){
        log.info("get meal");
        return service.get(id);
    }

}
