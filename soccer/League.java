/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soccer;

import java.util.ArrayList;

/**
 *
 * @author oracle
 */
public class League {
    public static void main(String[] args) {
        League league = new League();
        
        Team[] teams = getTeams();
        Game[] games = getGames(teams);
        
        System.out.println("Teams:");
        for(Game game : games) {
            game.playGame();
            System.out.println(game.getStatistics());
        }
        league.showBestTeam(teams);
    }
    
    private static Team[] getTeams() {
        Player[] homeTeamPlayers = new Player[11];
        String[] homePlayerNames = {"Fred Smith", "Harry Brown", "John Johnson", 
            "Joe Parker", "Mark Smith", "Jake Michaelson", "Ted Brown", "Bob Builder", 
            "David Beckham", "Mike Mackintosh", "Ravi Singh"};
        
        for(int i = 0; i < homeTeamPlayers.length; i++) {
            homeTeamPlayers[i] = new Player(homePlayerNames[i]);
        }
        
        Player[] awayTeamPlayers = new Player[11];
        String[] awayPlayerNames = {"Martin Hendrix", "Brian Cosby", "Hemant Sharma", 
            "Deepak Sharma", "Steve Sabatini", "Simon Twopie", "Matthew Croxley", 
            "Ray Kelly", "Nathan Meyers", "Harry Potter", "Ron Wesley"};
        
        for(int i = 0; i < awayTeamPlayers.length; i++) {
            awayTeamPlayers[i] = new Player(awayPlayerNames[i]);
        }
        
        return new Team[]{new Team("Reds", homeTeamPlayers), new Team("Blues", awayTeamPlayers)};
    }
    
    private static Game[] getGames(Team[] teams) {
        Game[] games = new Game[4];
        for(int i = 0; i < 4; i++) {
            Team homeTeam = getRandomTeam(teams);
            Team awayTeam = getRandomTeam(teams);
            while(homeTeam.getName().equals(awayTeam.getName())) {
                awayTeam = getRandomTeam(teams);
            }
            
            games[i] = new Game(homeTeam, awayTeam);
        }
        
        return games;
    }
    
    private static Team getRandomTeam(Team[] teams) {
        int length = teams.length;
        int index = 0;
        while(true) {
            index = (int) (Math.random() * length);
            if(index >= 0 && index < length) {
                break;
            }
        }
        return teams[index];
    }
    
    public void showBestTeam(Team[] teams) {
        Team bestTeam = teams[0];
        System.out.println("\nTeam Points");
        
        for(Team team: teams) {
            System.out.println(team.getName() + ": " + team.getScore() + " : " + team.getGoalsScored());
            if(team.getScore() > bestTeam.getScore()) {
                bestTeam = team;
            } else if(team.getScore() == bestTeam.getScore()) {
                if(team.getGoalsScored() > bestTeam.getGoalsScored()) {
                    bestTeam = team;
                }
            }
        }
        
        System.out.println("This year's champions are: " + bestTeam.getName());
    }    
}
