package com.example.springexample.services;

import com.example.springexample.errors.ErrorHandler;
import com.example.springexample.models.Enemy;
import com.example.springexample.models.Character;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.UUID;

@Service
public class CombatResolver {

    private UUID uuid;
    Character character;
    Enemy enemy; //could be better to define a list of encounter?
                 //[encounter1: [wolf1, wolf2, wolf3],
                 // encounter2: [bigbadwolf1], ...]

    public CombatResolver() {}
    public CombatResolver(Character character, Enemy enemy) {

        this.character = character;
        this.enemy = enemy;
    }

    //TODO
    //think about the other stats the character must use in combat
    // like criticalDamage resolver, rolls for damageRange, and critMultiplier

    // float critRatio = 20.0 => 20%
    // if(rand.nextInt(100) <= critRatio - 1) {System.out.println("You Critter")}

    // int dmgRange = 20
    // int dmg += rand.nextInt(100)

    //




    //and write some function to make them

    //also I'd like to see some dragons
    //don't use zombies for test the program
    //they could eat the character brain!

    //TODO
    public String resolveCombat() throws HttpClientErrorException {

        //Set initial names for debugging
        character.setName("Very Nice Hero");
        enemy.setName("Big Bad Wolf");


        //Stats used in combat calculation
        //character.setGold(100);
        int characterHealth = character.getHealth();
        int characterDamage = character.getDamage();
        int enemyHealth = enemy.getHealth();
        int enemyDamage = enemy.getDamage();

        //combat result string
        String winner = "Winner: ";

//        if(characterHealth == 0) {
//            return "You are near death! You really want to fight?";
//        }
        //combat resolution
        while(characterHealth > 0 && enemyHealth > 0) {
            enemyHealth -= characterDamage;

            if(enemyHealth <= 0) {
                winner += character.getName();
                return winner;
            }
            characterHealth = characterHealth - enemyDamage;
            if(characterHealth <= 0) {
                winner += enemy.getName();
                return winner;
            }

        }
        throw new ErrorHandler(HttpStatus.BAD_REQUEST, "You Loser");
    }

}
