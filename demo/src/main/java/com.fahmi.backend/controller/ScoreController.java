package com.fahmi.backend.controller;
import com.fahmi.backend.Model.Player;
import com.fahmi.backend.Model.Score;
import com.fahmi.backend.Service.PlayerService;
import com.fahmi.backend.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.*;

@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<?> createScore(@RequestBody Score score) {
        try {
            Score createdScore = scoreService.createScore(score);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdScore);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }


    }

    @GetMapping
    public ResponseEntity<?> getAllScores() {
        List<Score> scores = scoreService.getAllScores();
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/{scoreId}")
    public ResponseEntity<?> getScoreById(@PathVariable UUID scoreId) {
        Optional<Score> score = scoreService.getScoreById(scoreId);
        if (score.isPresent()) {
            return ResponseEntity.ok(score.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error Bang");
        }
    }


    @PutMapping("/{scoreId}")
    public ResponseEntity<?> updateScore(@PathVariable UUID scoreId, @RequestBody Score score) {
        try {
            Score updatedScore = scoreService.updateScore(scoreId, score);
            return ResponseEntity.ok(updatedScore);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteScore(@PathVariable UUID scoreId) {
        try {
            scoreService.deleteScore(scoreId);
            return ResponseEntity.ok("Selamat! Sukses");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }

    }

    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Score>> getScoresByPlayerId(@PathVariable UUID playerId) {
        List<Score> scores = scoreService.getScoresByPlayerId(playerId);
        return ResponseEntity.ok(scores);
    }

    public ResponseEntity<List<Score>> getScoresByPlayerIdOrdered(@PathVariable UUID playerId) {
        List<Score> scores = scoreService.getScoresByPlayerIdOrderByValue(playerId);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<Score>> getLeaderboard(@RequestParam(defaultValue = "10") int limit) {
        List<Score> scores = scoreService.getLeaderboard(limit);
        return ResponseEntity.ok(scores);
    }

    @GetMapping("/player/{playerId}/highest")
    public ResponseEntity<?> getHighestScoreByPlayerId(@PathVariable UUID playerId) {
        Optional<Score> highestScore = scoreService.getHighestScoreByPlayerId(playerId);

        if (highestScore.isPresent()) {
            return ResponseEntity.ok(highestScore.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Tak Ada Score");
        }
    }


    @GetMapping("/above/{minValue}")
    public ResponseEntity<List<Score>> getScoresAboveValue(@PathVariable Integer minValue) {
        List<Score> minScore = scoreService.getScoresAboveValue(minValue);
        return ResponseEntity.ok(minScore);
    }

    @GetMapping("/recent")
    public ResponseEntity<List<Score>> getRecentScores() {
        List<Score> recentscores = scoreService.getRecentScores();
        return ResponseEntity.ok(recentscores);
    }

    @GetMapping("/player/{playerId}/total-coins")
    public ResponseEntity<?> getTotalCoinsByPlayerId(@PathVariable UUID playerId) {
        int totalCoins = scoreService.getTotalCoinsByPlayerId(playerId);
        Map<String, Object> response = new HashMap<>();
        response.put("totalCoins", totalCoins);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/player/{playerId}/total-distance")
    public ResponseEntity<?> getTotalDistanceByPlayerId(@PathVariable UUID playerId) {
        int playerDihtance = scoreService.getTotalDistanceByPlayerId(playerId);
        Map<String, Object> playerdihtance = new HashMap<>();
        playerdihtance.put("totalCoins", playerDihtance);
        return ResponseEntity.ok(playerdihtance);

    }

    @DeleteMapping("/player/{playerId}")
    public ResponseEntity<?> deleteScoresByPlayerId(@PathVariable UUID playerId) {
        scoreService.deleteScoresByPlayerId(playerId);
        return ResponseEntity.ok("Sukses!");
    }


























}
