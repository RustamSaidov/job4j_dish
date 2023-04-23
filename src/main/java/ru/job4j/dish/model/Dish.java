package ru.job4j.dish.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Entity*/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {

    private int id;
    private String name;
    private String description;
}