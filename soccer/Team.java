package soccer;

public class Team {
    private String name;
    private Player[] players;
    private int score;
    private int goalsScored;
    
    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
    }
    
    public String getName() {
        return name;
    }
    
    public Player[] getPlayers() {
        return players;
    }
    
    public void increaseScore(int scoreAmount) {
        this.score += scoreAmount;
    }
    
    public int getScore() {
        return score;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void increaseGoalsScored() {
        this.goalsScored++;
    }
}
