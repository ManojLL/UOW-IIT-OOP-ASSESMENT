package services;

import entities.clubs.FootballClub;
import leagueManagers.PremierLeagueManager;
import leagueManagers.supportClasses.GoalCompare;
import leagueManagers.supportClasses.WinCompare;
import utils.PremierLeagueApplication;

import java.util.Collections;
import java.util.List;

public class TableService {

    private static TableService tableService;

    public static TableService getTableService() {
        if (tableService == null) {
            tableService = new TableService();
        }
        return tableService;
    }

    public List<FootballClub> leagueTableAccordingToPoints() {
        return PremierLeagueManager.getInstance().getFootballClubsList();
    }

    public List<FootballClub> leagueTableAccordingToNumOfWins() {
        List<FootballClub> listAccordingToWins = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(listAccordingToWins, new WinCompare());
        return listAccordingToWins;
    }

    public List<FootballClub> leagueTableAccordingToNumOfGoals() {
        List<FootballClub> listAccordingToGoals = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(listAccordingToGoals, new GoalCompare());
        return listAccordingToGoals;
    }
}
