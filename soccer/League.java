package soccer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import utility.PlayerDatabase;
import utility.PlayerDatabaseException;

public class League {
    public static void main(String[] args) {
        League league = new League();
        
        Team[] teams = null;
        try {
            teams = league.createTeams(new String[]{"Blues", "Reds", "Greens"}, 20);
        } catch(PlayerDatabaseException e) {
            e.printStackTrace();
        }
        if(teams == null) return;
        
        ArrayList<Game> games = league.createGames(teams);
        
        System.out.println(league.getLeagueAnnouncment(games));
        System.out.println("");
        System.out.println("Teams:");
        for(Game game : games) {
            game.playGame();
            System.out.println(game.getDescription());
        }
        league.showBestTeam(teams);
    }
    
    private Team[] createTeams(String[] teamNames, int numberOfPlayers) throws PlayerDatabaseException {
        PlayerDatabase playerDatabase = new PlayerDatabase();
        Team[] teams = new Team[teamNames.length];
        try {
            for(int i = 0; i < teamNames.length; i++) {
                teams[i] = new Team(teamNames[i], playerDatabase.getTeam(numberOfPlayers));
            }
        } catch(IndexOutOfBoundsException e) {
            throw new PlayerDatabaseException("Not enough players to create a team of " + numberOfPlayers + " players");
        }
        
        return teams;
    }
    
    private ArrayList<Game> createGames(Team[] teams) {
        LocalDateTime startDate = LocalDateTime.now();
        ArrayList<Game> games = new ArrayList<>();
        for (Team homeTeam : teams) {
            for (Team awayTeam : teams) {
                if (homeTeam != awayTeam) {
                    games.add(new Game(homeTeam, awayTeam, startDate));
                    startDate = startDate.plusDays(7);
                }
            }
        }        
        return games;
    }
    
    public void showBestTeam(Team[] teams) {
        Arrays.sort(teams);
        ArrayList<Team> bestTeams = new ArrayList<>();
        System.out.println("\nTeam Points");
        int highestScore = teams[0].getScore();
        
        for(Team team : teams) {
            System.out.println(team.getName() + ": " + team.getScore() + " : " + team.getGoalsScored());
            if(teams[0].compareTo(team) == 0) {
                bestTeams.add(team);
            }
        }
        
        System.out.print("This year's champions are: ");
        for(int i = 0; i < bestTeams.size(); i++) {
            if(i == bestTeams.size()-1) {
                System.out.print(bestTeams.get(i).getName() + "!");
            } else {
                System.out.print(bestTeams.get(i).getName() + ", ");                
            }
        }
        System.out.println("");
    }   
    
    public String getLeagueAnnouncment(ArrayList<Game> games) {
        LocalDate startDate = games.get(0).getStartDate().toLocalDate();
        LocalDate endDate = games.get(games.size()-1).getStartDate().toLocalDate();
        Period between = Period.between(startDate, endDate);
        return "The legue is scheduled to run for " + between.getMonths() + 
                " month(s), and " + between.getDays() + " day(s)";
    }
}
