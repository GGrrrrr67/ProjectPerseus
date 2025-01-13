package com.example.springexample.services;

import com.example.springexample.models.Player;
import com.example.springexample.repositories.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerInformation {

    private final PlayerRepository playerRepository;

    public PlayerInformation(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    //TODO
    public Player getPlayerById(UUID id) {
        return playerRepository.retrievePlayersById(id);
    }

    //TODO
    public Player getPlayerByName(String name) {
        return null;
    }

    //TODO
    public String postNewPlayer(Player player) {
        return playerRepository.savePlayer(player).toString();
    }

    //TODO
    public String updatePlayer(Player player) {
        return playerRepository.updatePlayer(player);
    }

    //TODO
    public String deletePlayer(UUID playerId) {
        return playerRepository.deletePlayer(playerId).toString();
    }
}
