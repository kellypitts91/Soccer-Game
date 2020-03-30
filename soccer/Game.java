package soccer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private ArrayList<GameEvent> gameEvents;
    private LocalDateTime startDate;
    
    public Game(Team homeTeam, Team awayTeam, LocalDateTime date) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.startDate = date;
    }
    
    public void playGame() {
        gameEvents = new ArrayList<GameEvent>();
       
        for(int i = 0; i < 90; i+= (i % 2 == 0 ? 5 : 7)) { //divisible by 2
            Team team = Math.random() > 0.5 ? homeTeam : awayTeam;
            Player player = team.getPlayers()[(int) (Math.random() * team.getPlayers().length)];
            GameEvent gameEvent = Math.random() > 0.5 ? 
                    new Goal(team, player, i) : 
                    new Possession(team, player, i);
            
            gameEvents.add(gameEvent);
        }
        
    }
    
    public String getDescription() {
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(homeTeam.getName())
          .append(" vs. ")
          .append(awayTeam.getName())
          .append("\n")
          .append("Date: ")
          .append(startDate.format(DateTimeFormatter.ISO_LOCAL_DATE))
          .append("\n");
        
        for(GameEvent gameEvent : gameEvents) {
            if(gameEvent instanceof Goal) {
                if(gameEvent.getTeam() == homeTeam) {
                    homeTeamGoals++;
                    homeTeam.increaseGoalsScored();
                } else {
                    awayTeamGoals++;
                    awayTeam.increaseGoalsScored();
                }
            }
            
            sb.append(gameEvent)
              .append("\n");
        }
        
        if(homeTeamGoals == awayTeamGoals) {
            sb.append("It's a draw!");
            homeTeam.increaseScore(1);
            awayTeam.increaseScore(1);
        } else if(homeTeamGoals > awayTeamGoals) {
            sb.append(homeTeam.getName()).append(" win");
            homeTeam.increaseScore(2);
        } else {
            sb.append(awayTeam.getName()).append(" win");
            awayTeam.increaseScore(2);
        }
        
        sb.append(" (")
          .append(homeTeamGoals)
          .append(" - ")
          .append(awayTeamGoals)
          .append(")")
          .append("\n");
        
        return sb.toString();
    }
    
    public Team getHomeTeam() {
        return homeTeam;
    }
    
    public Team getAwayTeam() {
        return awayTeam;
    }
    
    public ArrayList<GameEvent> getGameEvents() {
        return gameEvents;
    }
    
    public void setGameEvents(ArrayList<GameEvent> gameEvents) {
        this.gameEvents = gameEvents;
    }
    
    public void addGameEvent(GameEvent goal) {
        this.gameEvents.add(goal);
    }    
    
    public LocalDateTime getStartDate() {
        return startDate;
    }
}
