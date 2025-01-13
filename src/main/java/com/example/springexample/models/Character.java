package com.example.springexample.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Component
public class Character {

    private UUID id;
    private String name;
    private int age;

    private int damage;
    private int health;

    private int gold;
    private List<Weapon> equippedWeapons;

    public Character() {}
    public Character(int health, int damage) {
        this.id = UUID.randomUUID();
        this.health = health;
        this.damage = damage;
    }
    public Character(String name, int age, int damage, int health, int gold) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.damage = damage;
        this.health = health;
        this.gold = gold;
    }
}
