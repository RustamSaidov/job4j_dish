package ru.job4j.dish.service;

import ru.job4j.dish.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishService {

    Dish save(Dish dish);

    boolean deleteById(int id);

    boolean update(Dish dish);

    Optional<Dish> findById(int id);

    List<Dish> findAll();

    Optional<Dish> findByName(String name);
}
