package com.example.springexample.views;

import com.example.springexample.errors.ErrorHandler;
import com.example.springexample.models.Player;
import com.example.springexample.services.CombatResolver;
import com.example.springexample.services.PlayerInformation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PlayerViews {

    CombatResolver combatResolver;
    private final PlayerInformation playerInformation;

    public PlayerViews(CombatResolver combatResolver, PlayerInformation playerInformation) {
        this.combatResolver = combatResolver;
        this.playerInformation = playerInformation;
    }

    //TODO
    //Homepage
    @GetMapping(path="/")
    public String helloSpring() {
        return "HelloBlackNoob33, this is the Homepage";
    }

    //TODO
    @GetMapping(path="/player/{playerId}")
    public String getPlayer(@PathVariable String playerId) throws ErrorHandler {
        try {
            UUID.fromString(playerId);
        } catch (IllegalArgumentException e) {
            throw new ErrorHandler(HttpStatus.BAD_REQUEST, ": You must provide a valid UUID");
        }
        Player player = playerInformation.getPlayerById(UUID.fromString(playerId));
        if (player != null) {
            return player.toString();
        }
        throw new ErrorHandler(HttpStatus.NOT_FOUND, "Player not found");
    }

    //TODO
    @PostMapping(path="/player/")
    public String postPlayer(@RequestBody Player player) {
        if (player.getName() == null) {
            throw new ErrorHandler(HttpStatus.BAD_REQUEST, "You must provide a valid name");
        }
        return playerInformation.postNewPlayer(player);
    }

    //TODO
    @PatchMapping(path="/player/{playerId}")
    public String patchPlayer(@PathVariable String playerId,
                              @RequestBody Player player) {
        if (player.getName() == null) {
            throw new ErrorHandler(HttpStatus.BAD_REQUEST, "You must provide a valid Name");
        }
        if (!(player.getUuid().compareTo(UUID.fromString(playerId)) == 0)) {
            throw new ErrorHandler(HttpStatus.BAD_REQUEST, "You must provide a valid UUID");
        }
        try {
            playerInformation.getPlayerById(UUID.fromString(playerId));
        } catch (Exception e) {
            throw new ErrorHandler(HttpStatus.NOT_FOUND, "Player not found");
        }

        return playerInformation.updatePlayer(player);

    }

    @DeleteMapping(path="/player/{playerId}/")
    public String deletePlayer(@PathVariable String playerId) {
        try {
            playerInformation.getPlayerById(UUID.fromString(playerId));
        } catch (Exception e) {
            throw new ErrorHandler(HttpStatus.NOT_FOUND, "Player not found");
        }
        return playerInformation.deletePlayer(UUID.fromString(playerId));
    }

}
