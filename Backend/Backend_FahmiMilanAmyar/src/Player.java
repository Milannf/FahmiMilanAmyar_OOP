import java.time.LocalDateTime;
import java.util.UUID;

public class Player {
    UUID player;
    String username;
    int highscore;
    int totalCoins;
    int totalDistance;
    LocalDateTime createdAt = LocalDateTime.now();

    void Player(String username) {

    }

    ;

    void getPlayerID() {
        System.out.print(player);
    }

    int updateHighScore(int newScore) {

        return highscore += newScore;
    }

    void addCoins(int coins) {
        totalCoins += coins;

    }

    void addDistance(int distance) {
        totalDistance += distance;

    }

    void showDetail() {
        System.out.println("PlayerID: " + player);
        System.out.println("Username: " + username);
        System.out.println("High Score: " + highscore);
        System.out.println("Total Coins: " + totalCoins);
        System.out.println("Total Distance: " + totalDistance);
        System.out.println("Created At:" + createdAt);
    }


}
