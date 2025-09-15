import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player();
        Player player2 = new Player();
        player1.username = "Milan";
        player2.username = "Lima";

        Score score1 = new Score();
        Score score2 = new Score();
        Score score3 = new Score();
        score1.Score(UUID.randomUUID(), 1500, 250, 5000);
        score2.Score(UUID.randomUUID(), 3200, 750, 12000);
        score3.Score(UUID.randomUUID(), 1800, 300, 600);

        player1.addDistance(score1.distance);
        player1.addCoins(score1.coinsCollected);
        player1.updateHighScore(score1.score);

        player2.addDistance(score1.distance);
        player2.addCoins(score1.coinsCollected);
        player2.updateHighScore(score1.score);

        player1.showDetail();
        player2.showDetail();


    }
}