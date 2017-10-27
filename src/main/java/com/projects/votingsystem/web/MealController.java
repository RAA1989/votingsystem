package com.projects.votingsystem.web;


import com.projects.votingsystem.model.Meal;
import com.projects.votingsystem.service.MealService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import static com.projects.votingsystem.util.ValidationUtil.assureIdConsistent;
import static com.projects.votingsystem.web.MealController.URL;

@RestController
@RequestMapping(value = URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class MealController {
    static final String URL = "/meals";

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MealService service;

    @PostMapping
    public Meal createWithLocation(@RequestParam(value = "menuId") int menuId){

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Meal update(@RequestBody Meal meal){
        assureIdConsistent(meal, meal.getId());
        return service.update(meal);
    }

}
