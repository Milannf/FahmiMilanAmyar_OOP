package com.fahmi.backend.Repository; // Sesuaikan dengan package Anda

import com.fahmi.backend.Model.Score; // Sesuaikan dengan package Anda
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface ScoreRepository extends JpaRepository<Score, UUID> {
    // Method-method yang sudah ada
    List<Score> findByPlayerId(UUID playerId);
    List<Score> findByPlayerIdOrderByValueDesc(UUID playerId);
    List<Score> findByValueGreaterThan(Integer minValue);
    List<Score> findAllByOrderByCreatedAtDesc();

    // --- Method-method baru ditambahkan di bawah ---

    /**
     * 1. Global Top Scores (Leaderboard)
     * Mengambil daftar skor tertinggi global (leaderboard).
     * Untuk membatasi jumlah hasil (limit), panggil method ini dari service
     * dengan objek Pageable. Contoh: PageRequest.of(0, limit)
     */
    @Query("SELECT s FROM Score s ORDER BY s.value DESC")
    List<Score> findTopScores(Pageable pageable);

    /**
     * 2. Skor Tertinggi Spesifik Pemain
     * Mengambil daftar skor pemain, diurutkan dari nilai tertinggi.
     * Skor tertinggi adalah elemen pertama dari list yang dikembalikan.
     */
    @Query("SELECT s FROM Score s WHERE s.playerId = :playerId ORDER BY s.value DESC")
    List<Score> findHighestScoreByPlayerId(@Param("playerId") UUID playerId);

    /**
     * 3. Total Koin yang dikumpulkan by player
     * Menghitung total koin yang dikumpulkan oleh seorang pemain.
     */
    @Query("SELECT SUM(s.coinsCollected) FROM Score s WHERE s.playerId = :playerId")
    Integer getTotalCoinsByPlayerId(@Param("playerId") UUID playerId);

    /**
     * 4. Total Jarak Tempuh
     * Menghitung total jarak yang sudah ditempuh oleh seorang pemain.
     */
    @Query("SELECT SUM(s.distanceTravelled) FROM Score s WHERE s.playerId = :playerId")
    Integer getTotalDistanceByPlayerId(@Param("playerId") UUID playerId);
}

