package com.example.springexample.models;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Setter
@Getter
//@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
@Component
public class Player {

    private UUID uuid;
    private String name;
    private String avatarUrl;

    public Player() {}
    public Player(String name) {
        this.uuid = UUID.randomUUID();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                '}';
    }
}
