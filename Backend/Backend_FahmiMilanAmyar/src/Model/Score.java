package Model;

import java.time.LocalDateTime;
import java.util.UUID;

class Score {
    UUID scoreId = UUID.randomUUID();
    UUID playerId = UUID.randomUUID();
    Player player;
    int value;
    int coinsCollected;
    int distance;
    int score;
    LocalDateTime createdAt = LocalDateTime.now();

    void Score(UUID playerId, int score, int coinsCollected, int distance) {
    }

    int getValue() {
        return 0;
    }

    int getCoinsCollected() {
        return coinsCollected;
    }

    int getDistance() {
        return distance;
    }

    void showDetail() {
        System.out.println("PlayerID: " + player);
        System.out.println(score);
        System.out.println(coinsCollected);
        System.out.println(distance);
        System.out.println("Created At:" + createdAt);

    }
}
