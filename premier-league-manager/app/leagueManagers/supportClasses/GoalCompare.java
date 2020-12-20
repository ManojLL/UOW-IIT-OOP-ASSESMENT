package leagueManagers.supportClasses;

import entities.clubs.FootballClub;
import java.util.Comparator;

public class GoalCompare implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub clubOne, FootballClub clubTwo) {
        if (clubOne.getScoredGoal() > clubTwo.getScoredGoal()) return -1;
        if (clubOne.getScoredGoal() < clubTwo.getScoredGoal()) return 1;
        return 0;
    }
}
