package services;

import entities.clubs.FootballClub;
import leagueManagers.PremierLeagueManager;
import leagueManagers.supportClasses.GoalCompare;
import leagueManagers.supportClasses.WinCompare;
import utils.ApplicationIO;

import java.util.Collections;
import java.util.List;

public class TableService {
    private static TableService tableService;
    private List<FootballClub> footballClubs;

    private TableService() {
        ApplicationIO.loadClubData();
        footballClubs = PremierLeagueManager.getInstance().getFootballClubsList();
    }

    public synchronized static TableService getTableService() {
        if (tableService == null) {
            tableService = new TableService();
        }
        return tableService;
    }

    public List<FootballClub> leagueTableAccordingToPoints() {
//        List<FootballClub> listAccordingToPoints = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(footballClubs);
        return footballClubs;
    }

    public List<FootballClub> leagueTableAccordingToNumOfWins() {
//        List<FootballClub> listAccordingToWins = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(footballClubs, new WinCompare());
        return footballClubs;
    }

    public List<FootballClub> leagueTableAccordingToNumOfGoals() {
//        List<FootballClub> listAccordingToGoals = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(footballClubs, new GoalCompare());
        return footballClubs;
    }
}
