package com.fahmi.backend.controller; //sesuaikan
import com.fahmi.backend.Model.Player; //sesuaikan
import com.fahmi.backend.Model.Score;
import com.fahmi.backend.Service.PlayerService; // sesuaikan
import com.fahmi.backend.Service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@RestController
@RequestMapping("/api/scores")
@CrossOrigin(origins = "*")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @PostMapping
    public ResponseEntity<?> createScore(@RequestBody Score score){
        try(
                ScoreService.createScore(score)
                )
        catch(RuntimeException e);

        return ResponseEntity.status(e.getMessage());
    }

    @GetMapping
    public ResponseEntity<?> getAllScores(){
        ScoreService.getAllScores();
        return ResponseEntity.ok(Score);
    }

    @GetMapping
    public ResponseEntity<?> getScoreById(PathVariable UUID scoreId){
        ScoreService.getScoreById(scoreId);
    }




}
