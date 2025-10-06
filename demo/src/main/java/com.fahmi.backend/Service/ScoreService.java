package com.fahmi.backend.Service; // sesuaikan dengan package anda

import com.fahmi.backend.Model.Score;
import com.fahmi.backend.Repository.PlayerRepository;
import com.fahmi.backend.Repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;

    @Transactional
    public Score createScore(Score score) {
        if (score.getPlayer() == null || score.getPlayer().getId() == null) {
            throw new RuntimeException("Player information is missing in the score object.");
        }

        boolean playerExists = playerRepository.existsById(score.getPlayer().getId());
        if (!playerExists) {
            throw new RuntimeException("Player not found with ID: " + score.getPlayer().getId());
        }

        Score savedScore = scoreRepository.save(score);

        playerService.updatePlayerStats(savedScore);

        return savedScore;
    }


    public Optional<Score> getScoreById(UUID scoreId) {
        return scoreRepository.findById(scoreId);
    }

    public List<Score> getAllScores() {
        return scoreRepository.findAll();
    }

    public List<Score> getScoresByPlayerId(UUID playerId) {
        return scoreRepository.findByPlayerId(playerId);
    }

    public List<Score> getScoresByPlayerIdOrderByValue(UUID playerId) {
        return scoreRepository.findByPlayerIdOrderByValueDesc(playerId);
    }

    public List<Score> getLeaderboard(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return scoreRepository.findTopScores(pageable);
    }

    public Optional<Score> getHighestScoreByPlayerId(UUID playerId){
        List<Score> scores = scoreRepository.findHighestScoreByPlayerId(playerId);
        if (scores.isEmpty()) {
            return Optional.empty();
        } else {
            return Optional.of(scores.get(0));
        }
    }

    public List<Score> getScoresAboveValue(Integer minValue){
        return scoreRepository.findByValueGreaterThan(minValue);
    }

    public List<Score> getRecentScores(){
        return scoreRepository.findAllByOrderByCreatedAtDesc();
    }

    public Integer getTotalCoinsByPlayerId(UUID playerId){
        Integer total = scoreRepository.getTotalDistanceByPlayerId(playerId);
        return (total != null) ? total : 0;
    }
    public Integer getTotalDistanceByPlayerId(UUID playerId){
        Integer total = scoreRepository.getTotalDistanceByPlayerId(playerId);
        return (total != null) ? total : 0;
    }

    public Score updateScore(UUID scoreId, Score updatedScore){
        Score existingScore = scoreRepository.findById(scoreId)
                .orElseThrow(() -> new RuntimeException("Score Tak Nak Ada"));
        return scoreRepository.save(existingScore);
    }

    public void deleteScore(UUID scoreId){
        if (!scoreRepository.existsById(scoreId)) {
            throw new RuntimeException("Score not found");
        }
        scoreRepository.deleteById(scoreId);
    }

    public void deleteScoresByPlayerId(UUID playerId){
        List<Score> playerScores = scoreRepository.findByPlayerId(playerId);
        scoreRepository.deleteAll(playerScores);
    }


}