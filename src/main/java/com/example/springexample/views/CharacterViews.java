package com.example.springexample.views;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterViews {

    //TODO
    @GetMapping(path="/player/{playerId}/character/{characterId}")
    public String playerCharacter(@PathVariable String playerId,
                                  @PathVariable String characterId) {
        return null;
    }
    //@PostMapping(path="/player/{playerId}/character/{character}/")
    //@PutMapping(path="/player/{player}/character/{character}/")
    //@PatchMapping(path="/player/{player}/character/{character}/")
    //@DeleteMapping(path="/player/{player}/character/{character}/")
    //Same story as {player} for {character}
    //Remember to move the above functions
    //to the correct "View file"
}
