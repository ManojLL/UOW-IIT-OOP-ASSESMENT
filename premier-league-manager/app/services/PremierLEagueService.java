package services;

import entities.clubs.FootballClub;
import entities.date.Date;
import entities.match.Match;
import leagueManagers.PremierLeagueManager;
import leagueManagers.supportClasses.GoalCompare;
import leagueManagers.supportClasses.MatchDateCompare;
import leagueManagers.supportClasses.WinCompare;
import utils.ApplicationIO;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PremierLEagueService {
    private static PremierLEagueService premierLEagueService;

    public synchronized static  PremierLEagueService getPremierLEagueService() {
        ApplicationIO.loadMatchData();
        ApplicationIO.loadClubData();
        if (premierLEagueService == null) {
            premierLEagueService = new PremierLEagueService();
        }
        return premierLEagueService;
    }

    public List<FootballClub> leagueTableAccordingToPoints() {
        List<FootballClub> listAccordingToPoints = PremierLeagueManager.getInstance().getFootballClubsList();
        Collections.sort(listAccordingToPoints);
        return listAccordingToPoints;
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

    public Match createNewMatch() {
        if (PremierLeagueManager.getInstance().getClubCount() >= 2) {
            FootballClub teamA = PremierLeagueManager.getInstance().getRandomClub();
            FootballClub teamB = getClub(teamA, PremierLeagueManager.getInstance().getRandomClub());
            int teamAScore = getGoals();
            int teamBScore = getGoals();
            Date matchDate = PremierLeagueManager.getInstance().getCurrentDate();
            String status = "";
            if (teamAScore == teamBScore) {
                status = "Match is draw";
            } else if (teamAScore > teamBScore) {
                status = "Match won by " + teamA.getClubName();
            } else {
                status = "Match won by " + teamB.getClubName();
            }
            Match match = new Match(teamA, teamB, matchDate, teamAScore, teamBScore, status);

            PremierLeagueManager.getInstance().addMatch(match);
            ApplicationIO.saveClubData();
            ApplicationIO.saveMatchData();
            return match;
        }
        return null;
    }

    private FootballClub getClub(FootballClub teamA, FootballClub teamB) {
        while (teamA.equals(teamB)) {
            teamB = PremierLeagueManager.getInstance().getRandomClub();
        }
        return teamB;
    }

    private int getGoals() {
        return new Random().nextInt(10);
    }

    public List<Match> matchesAccordingToDate() {
        List<Match> matchList = PremierLeagueManager.getInstance().getMatchList();
        Collections.sort(matchList, new MatchDateCompare());
        return matchList;
    }
}
