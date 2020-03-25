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
            System.out.println("Goal count = " + goalCount);
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
    
    public void printStatistics() {
        System.out.println("Goal length = " + goals.length);
        for(Goal goal : goals) {
            System.out.println("Goal scored after " + goal.getTime() + " mins by " + 
                    goal.getPlayer().getName() + " of the " + goal.getTeam().getName());
        }
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
