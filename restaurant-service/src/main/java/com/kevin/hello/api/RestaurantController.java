package com.kevin.hello.api;

import com.kevin.hello.common.Entity;
import com.kevin.hello.service.RestaurantService;
import com.kevin.hello.ddd.Restaurant;
import com.kevin.hello.vo.RestaurantVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/v1/restaurants")
public class RestaurantController {

    private Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    protected RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    public ResponseEntity<Collection<Restaurant>> findByName(@RequestParam("name") String name) {
        logger.info(String.format("restaurant-service findByName() invoked: {1} for {2}", restaurantService.getClass().getName(), name));

        name = name.trim().toLowerCase();
        Collection<Restaurant> restaurants;
        try {
            restaurants = restaurantService.findByName(name);
        } catch (Exception e) {
            logger.warn("Exception raised by findByName REST Call", e);

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @RequestMapping("/{restaurant_id}")
    public ResponseEntity<Entity> findById(@PathVariable("restaurant_id") String restaurantId) {
        logger.info(String.format("restaurant-service findById() invoked: {1} for {2}", restaurantService.getClass().getName(), restaurantId));

        restaurantId = restaurantId.trim();
        Entity restaurant;
        try {
            restaurant = restaurantService.findById(restaurantId);
        }catch (Exception e) {
            logger.error("Exception raised by findById REST Call", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Restaurant> add(RestaurantVO restaurantVO) {
        Restaurant restaurant = new Restaurant(null, null, null);
        BeanUtils.copyProperties(restaurantVO, restaurant);

        try{
            restaurantService.add(restaurant);
        } catch (Exception e) {
            logger.warn("Exception raised by add REST Call", e);
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
