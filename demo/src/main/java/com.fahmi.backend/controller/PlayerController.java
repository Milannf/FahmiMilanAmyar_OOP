package com.fahmi.backend.controller;

import com.fahmi.backend.Model.Player;
import com.fahmi.backend.Service.PlayerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers(){
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayerById(@PathVariable UUID playerId){
        Optional<Player> player = playerService.getPlayerById(playerId);
        if (player.isPresent()){
            return ResponseEntity.ok(player.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<?> getPlayerByUsername(@PathVariable UUID playerId){
        Optional<Player> player = playerService.getPlayerByUsername(playerId);
        if (player.isPresent()){
            return ResponseEntity.ok(player.get());
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<?> checkUsername(@PathVariable String username){
        return playerService.isUsernameExists(username);
    }

    @PostMapping
    public ResponseEntity<?> createPlayer(@RequestBody Player player){
        try {playerService.createPlayer(player);}
        catch (Error){
            return HttpStatus.CREATED;
        }
    }

    @PutMapping("/{playerId}")
    public Player createPlayer(Player player) {
        if (playerService.updatePlayer(playerId, player)) {
            throw new RuntimeException("Username already exists: " + player.getUsername());}

        return HttpStatus.NOT_FOUND;
    }

    @DeleteMapping("/{playerId}")
    public deletePlayer(@PathVariable UUID playerId){
        try {
            playerService.deletePlayer(playerId);
        }
        catch (Error){
            return HttpStatus.NOT_FOUND;
        }
    }

    @GetMapping("/leaderboard/high-score")
    public ResponseEntity<List<Player>> getLeaderboardByHighScore(@RequestParam(defaultValue = "10") int limit){
        return Player;
    }






}
