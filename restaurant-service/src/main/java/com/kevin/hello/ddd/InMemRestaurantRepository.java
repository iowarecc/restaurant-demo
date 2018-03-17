package com.kevin.hello.ddd;

import com.kevin.hello.ddd.Restaurant;
import com.kevin.hello.ddd.RestaurantRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository("restaurantRepository")
public class InMemRestaurantRepository implements RestaurantRepository<Restaurant, String> {

    private Map<String, Restaurant> restaurants;

    public InMemRestaurantRepository() {
        restaurants = new HashMap<>();
    }

    @Override
    public boolean containsName(String name) throws Exception {
        return restaurants.containsKey(name);
    }

    @Override
    public void add(Restaurant entity) {
        restaurants.put(entity.getName(), entity);
    }

    @Override
    public void remove(String id) {
        if(restaurants.containsKey(id)) {
            restaurants.remove(id);
        }
    }

    @Override
    public void update(Restaurant entity) {

    }

    @Override
    public boolean contains(String id) {
        throw new UnsupportedOperationException("not supported yet!");
    }

    @Override
    public Restaurant get(String id) {
        return null;
    }

    @Override
    public Collection<Restaurant> getAll() {
        throw new UnsupportedOperationException("not support yet");
    }
}
