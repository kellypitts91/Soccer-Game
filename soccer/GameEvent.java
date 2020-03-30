package soccer;

public abstract class GameEvent {
    protected Team team;
    protected Player player;
    protected double time;
    
    public GameEvent(Team team, Player player, double time) {
        this.team = team;
        this.player = player;
        this.time = time;
    }
    
    public Team getTeam() {
        return team;
    }
    
    public Player getPlayer() {
        return player;
    }
    
    public double getTime() {
        return time;
    } 
}
