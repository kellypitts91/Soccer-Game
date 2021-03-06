package soccer;

public class Goal extends GameEvent {
    
    public Goal(Team team, Player player, double time) {
        super(team, player, time);
    }    
    
    @Override
    public String toString() {
        return "Goal scored after " +
              time + " mins by " +
              player.getName() + " of the " +
              team.getName();
    }
}
