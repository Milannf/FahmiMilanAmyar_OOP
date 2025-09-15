import Model.player;

class PlayerRepository<Player, UUID> extends BaseRepository{
    Player player;
    String username;
    String allData;

    public Optional<Player> findByUsername(String username)
    {
        return allData.stream()
                .filter(player -> player.getUsername().equals(username))
                .findFirst();
    }
    public Optional<Player> findTopPlayersByHighScore(int limit)
    {
        return allData.stream()
                .sorted()
                .findFirst();
    }
    void findByHighscoreGreaterThan(int minScore){
        return allData.stream()
                .filter(n -> n > minScore)
                .findFirst();
    }
    void findALlByOrderByTotalCoinsDesc(){
        return allData.stream()
                .compareTo()
                .findFirst();
    }
    void findAllByOrderByTotalDistanceTravelledDesc(){

    }
    void save(Player player){

    }
    void getID(Player entity){

    }
}