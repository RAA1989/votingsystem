package com.projects.votingsystem.web;


import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.service.VoteService;
import com.projects.votingsystem.to.RestaurantRatingTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static com.projects.votingsystem.util.ValidationUtil.assureIdConsistent;


@RestController
@RequestMapping(value = VoteController.URL)//, produces = MediaType.APPLICATION_JSON_VALUE)
public class VoteController {
    static final String URL = "/votes";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private VoteService service;

    @GetMapping(value = "/result")
    public List<RestaurantRatingTo> showVotes(){
        log.info("counting all votes by the given date");
        //return service.countVotes(LocalDate.now());
        return service.countVotes(LocalDate.of(2015, Month.MAY, 31));
    }

    @PostMapping
    public ResponseEntity<Vote> createWithLocation(@RequestParam(value = "restaurantId") int restaurantId){
        log.info("creating a vote");
        int userId = 100000;
        Vote created = service.create(userId,restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vote update(@RequestBody Vote vote, @RequestParam(value = "restaurantId") int restaurantId, @PathVariable int id){
        log.info("updateing a vote");
        int userId = 100000;
        assureIdConsistent(vote, id);
        return service.update(vote, restaurantId);
    }

    @GetMapping
    public List<Vote> getAllByUser(){
        log.info("getting all votes by user id");
        int userId = 100000;
        return service.getAllByUser(userId);
    }

    @GetMapping(value = "/last")
    public Vote getLast(){
        log.info("getting all votes by user id");
        int userId = 100000;
        return service.getLast(userId);
    }
}
