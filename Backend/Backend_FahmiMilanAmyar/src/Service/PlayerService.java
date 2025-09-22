package Service;

import Model.Player;
import Repository.BaseRepository;
import Repository.PlayerRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PlayerService{
    private PlayerRepository playerRepository;
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public boolean ExistByUsername(String username){
        if (playerRepository.findByUsername().equals(username)){
            return true;
        }
        else {
            return false;
        }
    }
    public List<Player> createPlayer(Player player){
        if (ExistByUsername(player.getUsername().equals(player)))
        playerRepository.save(player);
    }

    public Optional<Player> getPlayerByID(UUID playerId){
    }

    public Optional<Player> getPlayerByUsername(String username){
       return getPlayerByUsername().get(player);
    }
    public List<Player> getAllPlayers(){
        return getAllPlayers();
    }

    public updatePlayer(UUID playerId, Player updatedPlayer){
        // bismillah
    }

    public deletePlayer(UUID playerId){
        int PLAYER = getPlayerByID();
        playerRepository.remove.player;
    }

    public updatePlayerStats(UUID playerId, int scoreValue, in coinsCollected, int distanceTravelled){
        // Bismillah 7 menit lagi
    }

    public void deletePlayerBYUsername(String username){

    }

    public List<Player> getLeaderboardByHighSchore(int highscoree){
        return 0;
    }

    public Optional<Player> getPlayerById(UUID uuid){
        return 0;
    }






}
