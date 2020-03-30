package soccer;

public class Possession extends GameEvent {
    
    public Possession(Team team, Player player, double time) {
        super(team, player, time);
    }
    
    @Override
    public String toString() {
        return "Possession after " +
              time + " mins by " +
              player.getName() + " of the " +
              team.getName();
    }
}
