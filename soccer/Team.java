package soccer;

public class Team implements Comparable {
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

    @Override
    public int compareTo(Object o) {
        Team team = null;
        if(o instanceof Team) {
            team = (Team) o;
        }
        
        if(team != null) {
            if(this.score > team.score) {
                return -1;
            } else if(this.score < team.score) {
                return 1;
            } else {
                if(this.goalsScored > team.goalsScored) {
                    return -1;
                } else if(this.goalsScored < team.goalsScored) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
        return -1;
    }
}
