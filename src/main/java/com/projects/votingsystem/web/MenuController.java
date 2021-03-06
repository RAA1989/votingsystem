package com.projects.votingsystem.web;

import com.projects.votingsystem.model.Menu;
import com.projects.votingsystem.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.List;

import static com.projects.votingsystem.web.MenuController.URL;

@RestController
@RequestMapping(value = URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {
    static final String URL = "/menus";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService service;

    @GetMapping(value = "/{restaurantId}")
    public List<Menu> getByRestaurant(@PathVariable int restaurantId){
        log.info("get all menu by restaurant");
        return service.getAllByRestaurant(restaurantId);
    }

    @PostMapping
    public ResponseEntity<Menu> createWithLocation(@RequestParam(value = "restaurantId") int restaurantId){
        log.info("create a menu");
        Menu created = service.create(restaurantId);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }
}
