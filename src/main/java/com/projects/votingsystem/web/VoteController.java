package com.projects.votingsystem.web;


import com.projects.votingsystem.AuthorizedUser;
import com.projects.votingsystem.model.Vote;
import com.projects.votingsystem.service.VoteService;
import com.projects.votingsystem.to.RestaurantRatingTo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@RestController
@RequestMapping(value = VoteController.URL, produces = MediaType.APPLICATION_JSON_VALUE)
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
    public ResponseEntity<Vote> createWithLocation(@AuthenticationPrincipal AuthorizedUser authorizedUser, @RequestParam(value = "restaurantId") int restaurantId){
        log.info("creating a vote");
        int userId = authorizedUser.getId();
        Vote created = service.createOrUpdate(userId,restaurantId);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();

        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @GetMapping
    public List<Vote> getAllByUser(@AuthenticationPrincipal AuthorizedUser authorizedUser){
        log.info("getting all votes by user id");
        int userId = authorizedUser.getId();
        return service.getAllByUser(userId);
    }

    @GetMapping(value = "/last")
    public Vote getLast(@AuthenticationPrincipal AuthorizedUser authorizedUser){
        log.info("getting all votes by user id");
        int userId = authorizedUser.getId();
        return service.getLast(userId);
    }
}
