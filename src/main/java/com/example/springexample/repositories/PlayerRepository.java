package com.example.springexample.repositories;

import com.example.springexample.models.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PlayerRepository {
    List<Player> players;

    public PlayerRepository() {
        players = new ArrayList<>();
    }

    public List<Player> retrieveAllPlayers() {
        return players;
    }

    public Player retrievePlayersById(UUID playerId) {
        UUID uuid;
        for (Player player : players) {
            uuid = player.getUuid();
            if (uuid.compareTo(playerId) == 0) {
                return player;
            }
        }
        return null;
    }

    public UUID savePlayer(Player player) {
        //player.setUuid(UUID.randomUUID());
        players.add(player);
        return player.getUuid();
    }

    public String updatePlayer(Player player) {
        for (Player p : players) {
            if (player.getUuid().compareTo(p.getUuid()) == 0) {
                int index = players.indexOf(p);
                players.set(index, player);
                return player.getUuid().toString();
            }
        }
        return null;
    }

    public UUID deletePlayer(UUID playerId) {
        for (Player p : players) {
            if (playerId.compareTo(p.getUuid()) == 0) {
                players.remove(p);
                return playerId;
            }
        }
        return null;
    }

}
