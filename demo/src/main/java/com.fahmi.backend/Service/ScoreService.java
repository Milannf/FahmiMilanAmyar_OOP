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

    public List<Score> getHighestScoreByPlayerId(UUID playerId){
        if (getAllScores().isEmpty()) {
            return Optional.empty(Score);
        }
        else{
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
        return scoreRepository.getTotalDistanceByPlayerId(playerId);
    }
    public Integer getTotalDistanceByPlayerId(UUID playerId){
        return scoreRepository.getTotalDistanceByPlayerId(playerId);
    }

    public Score updateScore(UUID scoreId, Score updatedScore){
        scoreRepository.findById(scoreId).orElseThrow(() -> new RuntimeException());
        return scoreRepository.save(existingScore);
    }

    public Score deleteScore(UUID scoreId){
        scoreRepository.existsById(scoreId).orElseThrow(() -> new RuntimeException());
        scoreRepository.deleteById(scoreId);
        return null;
    }

    void deleteScoresByPlayerId(UUID playerId){
        scoreRepository.findByPlayerId(playerId);
        scoreRepository.deleteAll();
    }





}