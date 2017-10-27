package com.projects.votingsystem.util;

import com.projects.votingsystem.model.Restaurant;
import com.projects.votingsystem.to.RestaurantRatingTo;

import java.util.*;

public class RestaurantUtil {

    public static List<RestaurantRatingTo> votingResultAsTo(Map<Restaurant,Integer> map){
        List<RestaurantRatingTo> list = new ArrayList<RestaurantRatingTo>();
        for(Map.Entry<Restaurant, Integer> entry : map.entrySet()){
            list.add(new RestaurantRatingTo(entry.getKey().getName(), entry.getValue()));
        }
        list.sort((o1, o2) -> Integer.valueOf(o2.getRating()).compareTo(o1.getRating()));
        return list;
    }
}
