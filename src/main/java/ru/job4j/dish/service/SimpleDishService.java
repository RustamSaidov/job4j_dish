package ru.job4j.dish.service;

import lombok.AllArgsConstructor;
import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.repository.DishRepository;

import java.util.List;
import java.util.Optional;

@ThreadSafe
@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {
    private final DishRepository dishRepository;

    @Override
    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public boolean deleteById(int id) {
        return dishRepository.deleteById(id);
    }

    @Override
    public boolean update(Dish dish) {
        boolean result = false;
        var current = dishRepository.findById(dish.getId());
        if (current.isEmpty()) {
            return result;
        }
        dishRepository.save(dish);
        result = true;
        return result;
    }

    @Override
    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }

    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }


    @Override
    public Optional<Dish> findByName(String name) {
        return dishRepository.findByName(name);
    }
}
