package com.fahmi.backend.controller;

import com.fahmi.backend.Model.Player;
import com.fahmi.backend.Service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/players") // FIX: Base path for all endpoints
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    // 4a. GET /api/players - Get Semua Player
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    // 4b. GET /api/players/{playerId} - Get Player Berdasarkan ID
    @GetMapping("/{playerId}")
    public ResponseEntity<?> getPlayerById(@PathVariable UUID playerId) {
        Optional<Player> player = playerService.getPlayerById(playerId);
        if (player.isPresent()) {
            return ResponseEntity.ok(player.get());
        } else {
            // FIX: Returning a proper ResponseEntity with a body for the 404 status
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found with ID: " + playerId);
        }
    }

    // 4c. GET /api/players/username/{username} - Get Player Berdasarkan Username
    @GetMapping("/username/{username}")
    // FIX: Corrected method signature to accept a String username
    public ResponseEntity<?> getPlayerByUsername(@PathVariable String username) {
        Optional<Player> player = playerService.getPlayerByUsername(username);
        if (player.isPresent()) {
            return ResponseEntity.ok(player.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found with username: " + username);
        }
    }

    // 4d. GET /api/players/check-username/{username} - Cek Ketersediaan Username
    @GetMapping("/check-username/{username}")
    // FIX: Corrected return type and logic
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        boolean exists = playerService.isUsernameExists(username);
        return ResponseEntity.ok(exists);
    }

    // 5a. POST /api/players - Membuat Player Baru
    @PostMapping
    // FIX: Corrected try-catch block and response logic
    public ResponseEntity<?> createPlayer(@RequestBody Player player) {
        try {
            Player createdPlayer = playerService.createPlayer(player);
            return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // 6a. PUT /api/players/{playerId} - Memperbarui Player
    @PutMapping("/{playerId}")
    // FIX: Corrected method signature, logic, and responses
    public ResponseEntity<?> updatePlayer(@PathVariable UUID playerId, @RequestBody Player player) {
        try {
            Player updatedPlayer = playerService.updatePlayer(playerId, player);
            return ResponseEntity.ok(updatedPlayer);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // 6b. DELETE /api/players/{playerId} - Menghapus Player
    @DeleteMapping("/{playerId}")
    // FIX: Corrected method signature, try-catch, and responses
    public ResponseEntity<?> deletePlayer(@PathVariable UUID playerId) {
        try {
            playerService.deletePlayer(playerId);
            return ResponseEntity.noContent().build(); // Standard response for successful deletion
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // 7a. GET /api/players/leaderboard/high-score
    @GetMapping("/leaderboard/high-score")
    // FIX: Corrected implementation to call the service
    public ResponseEntity<List<Player>> getLeaderboardByHighScore(@RequestParam(defaultValue = "10") int limit) {
        List<Player> leaderboard = playerService.getLeaderboardByHighScore(limit);
        return ResponseEntity.ok(leaderboard);
    }

    // 7b. GET /api/players/leaderboard/total-coins
    @GetMapping("/leaderboard/total-coins")
    // FIX: Added missing method
    public ResponseEntity<List<Player>> getLeaderboardByTotalCoins() {
        List<Player> leaderboard = playerService.getLeaderboardByTotalCoins();
        return ResponseEntity.ok(leaderboard);
    }

    // 7c. GET /api/players/leaderboard/total-distance
    @GetMapping("/leaderboard/total-distance")
    // FIX: Added missing method
    public ResponseEntity<List<Player>> getLeaderboardByTotalDistance() {
        List<Player> leaderboard = playerService.getLeaderboardByTotalDistance();
        return ResponseEntity.ok(leaderboard);
    }
}