package com.kevin.hello.service.impl;

import com.kevin.hello.common.BaseService;
import com.kevin.hello.common.Entity;
import com.kevin.hello.ddd.Restaurant;
import com.kevin.hello.ddd.RestaurantRepository;
import com.kevin.hello.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Service("restaurantService")
public class RestaurantServiceImpl extends BaseService<Restaurant, String> implements RestaurantService {


    @Autowired
    private RestaurantRepository<Restaurant, String> restaurantRepository;

    @Override
    public void add(Restaurant restaurant) throws Exception {
        if(StringUtils.isEmpty(restaurant.getName())) {
            throw new Exception("Restaurant name cannot be null or empty string.");
        }

        if(restaurantRepository.containsName(restaurant.getName())) {
            throw new Exception(String.format("there is already a restaurant with name: {}", restaurant.getName()));
        }

        super.add(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) throws Exception {
        restaurantRepository.update(restaurant);
    }

    @Override
    public void delete(String id) throws Exception {
        restaurantRepository.remove(id);
    }

    @Override
    public Entity findById(String restaurantId) throws Exception {
        return restaurantRepository.get(restaurantId);
    }

    @Override
    public Collection<Restaurant> findByCriteria(Map<String, ArrayList<String>> criteria) throws Exception {
        throw new UnsupportedOperationException("not support yet.");
    }
}
