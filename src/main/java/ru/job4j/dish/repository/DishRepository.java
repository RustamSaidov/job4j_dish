package ru.job4j.dish.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.dish.model.Dish;

import java.util.List;
import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Integer> {

    List<Dish> findAll();

    boolean deleteById(int id);

    Optional<Dish> findByName(String name);
}
