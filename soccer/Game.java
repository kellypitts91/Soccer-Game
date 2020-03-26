package soccer;

import static utility.GameUtils.addGameGoals;

public class Game {
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;
    
    public Game(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    
    public void playGame(int maxGoals) {
        int goalCount = maxGoals;
        while(true) {
            goalCount = (int) (Math.random() * maxGoals) + 1;
            if(goalCount > 0 && goalCount <= maxGoals) {
                break;
            }
        }
        goals = new Goal[(int) goalCount];
        
        addGameGoals(this);
    }
    
    public void playGame() {
        playGame(6);
    }
    
    public String getStatistics() {
        int homeTeamGoals = 0;
        int awayTeamGoals = 0;
        
        StringBuilder sb = new StringBuilder();
        sb.append(homeTeam.getName())
          .append(" vs. ")
          .append(awayTeam.getName())
          .append("\n");
        
        for(Goal goal : goals) {
            if(goal.getTeam() == homeTeam) {
                homeTeamGoals++;
                homeTeam.increaseGoalsScored();
            } else {
                awayTeamGoals++;
                awayTeam.increaseGoalsScored();
            }
            
            sb.append("Goal scored after ")
              .append(goal.getTime())
              .append(" mins by ")
              .append(goal.getPlayer().getName())
              .append(" of the ")
              .append(goal.getTeam().getName())
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
    
    public Goal[] getGoals() {
        return goals;
    }
    
    public void setGoals(Goal[] goals) {
        this.goals = goals;
    }
    
    public void addGoal(Goal goal, int index) {
        this.goals[index] = goal;
    }
}
