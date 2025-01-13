package com.example.springexample.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Component
public class Enemy {

    private UUID id;
    private String name;
    private int health;
    private int damage;


    public Enemy() {}
    public Enemy(int health, int damage) {
        this.id = UUID.randomUUID();
        this.health = health;
        this.damage = damage;
    }
    public Enemy(String name, int health, int damage) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

}
