package leagueManagers;

import entities.clubs.SportClub;
import entities.match.Match;

public interface LeagueManager {
    boolean addClubToLeague(SportClub sportClub);

    boolean deleteSportClub(SportClub sportClub);

    void displayStatsOfClub(SportClub sportClub);

    void displayLeagueTable();

    void addMatch(Match match);

    void saveData();

    void loadData();
}
