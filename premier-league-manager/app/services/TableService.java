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
    private static List<FootballClub> footballClubs;

    private TableService() {
    }

    public synchronized static TableService getTableService() {
        ApplicationIO.loadClubData();
        footballClubs = PremierLeagueManager.getInstance().getFootballClubsList();
        if (tableService == null) {
            tableService = new TableService();
        }
        return tableService;
    }

    public synchronized List<FootballClub> leagueTableAccordingToPoints() {
//        List<FootballClub> listAccordingToPoints = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(footballClubs);
        return footballClubs;
    }

    public synchronized List<FootballClub> leagueTableAccordingToNumOfWins() {
//        List<FootballClub> listAccordingToWins = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(footballClubs, new WinCompare());
        return footballClubs;
    }

    public synchronized List<FootballClub> leagueTableAccordingToNumOfGoals() {
//        List<FootballClub> listAccordingToGoals = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(footballClubs, new GoalCompare());
        return footballClubs;
    }
}
