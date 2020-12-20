package leagueManagers.supportClasses;

import entities.clubs.FootballClub;
import java.util.Comparator;

public class WinCompare implements Comparator<FootballClub> {


    @Override
    public int compare(FootballClub club1, FootballClub club2) {
        if (club1.getNumOfWin() > club2.getNumOfWin()) return -1;
        if (club1.getNumOfWin() < club2.getNumOfWin()) return 1;
        return 0;
    }
}
