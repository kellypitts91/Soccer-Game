package utility;

import soccer.Goal;
import soccer.Game;
import soccer.Team;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import soccer.Player;

/**
 *
 * @author ksomervi
 */
public class GameUtils {

    public static void addGameGoals(Game currGame) {
        
        //System.out.println(currGame.awayTeam + " : " + currGame.homeTeam);

        // Or possibly throw an Exception?
        if (currGame.getGoals() == null) {
            currGame.setGoals(new Goal[(int) (Math.random() * 10)]);   // If goals not initialized max will be 9
        }

        //System.out.println(currGame.goals.length);
        int i = 0;
        for (Goal currGoal : currGame.getGoals()) {
            Team team = Math.random() > 0.5 ? currGame.getHomeTeam() : currGame.getAwayTeam();
            Player player = team.getPlayers()[(int) (Math.random() * team.getPlayers().length)];
            double time = (int) (Math.random() * 90);
            currGoal = new Goal(team, player, time);
            
            currGame.addGoal(currGoal, i);
            i++;
        }
        Arrays.sort(currGame.getGoals(), (g1, g2) -> Double.valueOf(g1.getTime()).compareTo(Double.valueOf(g2.getTime())));

    }
}
