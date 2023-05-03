package ru.job4j.dish.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.dish.model.Dish;
import ru.job4j.dish.service.DishService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dish")
@Data
@Slf4j
public class DishController {

    private final DishService dishService;

    @GetMapping("/all")
    public ResponseEntity<List<Dish>> getAll() {
        return ResponseEntity.of(Optional.of(dishService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findById(@PathVariable int id) {
        var site = this.dishService.findById(id);
        return new ResponseEntity<Dish>(
                site.orElse(new Dish()),
                site.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        try {
            this.dishService.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception exception) {
            log.error("An error occurred while deleting Dish with id {}", id, exception);
        }
        return ResponseEntity.notFound().build();
    }
}
