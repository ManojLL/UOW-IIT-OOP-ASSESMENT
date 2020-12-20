package leagueManagers.supportClasses;

import entities.match.Match;
import java.util.Comparator;

public class MatchDateCompare implements Comparator<Match> {
    @Override
    public int compare(Match match1, Match match2) {
        return match1.getDate().compareTo(match2.getDate());
    }
}
