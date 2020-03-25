package soccer;

public class League {
    public static void main(String[] args) {
        League league = new League();
        
        Team[] teams = getTeams();
        Game[] games = getGames(teams);
        
        System.out.println("Teams:");
        for(Team team : teams) {
            System.out.println(team.getName());
            for(Player player : team.getPlayers()) {
                String[] name = player.getName().split(" ");
                System.out.println(name[1] + ", " + name[0]);
            }
            System.out.println("");
        }
        
        for(Game game : games) {
            game.playGame();
            game.printStatistics();
        }
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
        return new Game[] {new Game(teams[0], teams[1])};
    }
}
