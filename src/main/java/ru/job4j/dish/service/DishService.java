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
public class DishService {
    private final DishRepository dishRepository;

    public Dish save(Dish dish) {
        return dishRepository.save(dish);
    }

    public boolean deleteById(int id) {
        return dishRepository.deleteById(id);
    }


    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }
}
