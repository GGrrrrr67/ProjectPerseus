package com.example.springexample.beanconfig;

import com.example.springexample.repositories.PlayerRepository;
import com.example.springexample.services.PlayerInformation;
import com.example.springexample.views.PlayerViews;
import com.example.springexample.models.Character;
import com.example.springexample.models.Enemy;
import com.example.springexample.models.Player;
import com.example.springexample.services.CombatResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//It could be usefully to figure a way
//To separate the bean config file
//In this way it could be easier to understand
//to which "Beans" we should look for
//in case there is the necessity
//for example we could apply the MVServices model

@Configuration
@ComponentScan
public class BeanConfiguration {

    @Bean
    public Player player() {
        return new Player();
    }

    @Bean
    public Character character() {
        return new Character();
    }

    @Bean
    public Character characterWithBaseCombatStats() {
        return new Character(0, 3);
    }

    @Bean
    public Enemy enemy() {
        return new Enemy();
    }
    @Bean
    public Enemy enemyWithBaseCombatStats() {
        return new Enemy(7,2);
    }

    @Bean
    public CombatResolver combatResolver() {
        return new CombatResolver(characterWithBaseCombatStats(), enemyWithBaseCombatStats());
    }
    @Bean
    public PlayerRepository playerRepository() {
        return new PlayerRepository();
    }
    @Bean
    public PlayerInformation playerInformation() {
        return new PlayerInformation(playerRepository());
    }
    @Bean
    public PlayerViews playerViews() {
        return new PlayerViews(combatResolver(), playerInformation());
    }

}
