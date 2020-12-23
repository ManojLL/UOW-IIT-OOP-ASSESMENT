package services;

import entities.clubs.FootballClub;
import entities.date.Date;
import entities.match.Match;
import leagueManagers.PremierLeagueManager;
import leagueManagers.supportClasses.MatchDateCompare;
import utils.ApplicationIO;
import utils.PremierLeagueApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MatchService {
    private static MatchService premierLeagueService;

    private MatchService() {
    }

    public synchronized static MatchService getInstance() {
        if (premierLeagueService == null) {
            premierLeagueService = new MatchService();
        }
        return premierLeagueService;
    }

    public Match createNewMatch() {
        ApplicationIO.loadMatchData();
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
        ApplicationIO.loadMatchData();
        List<Match> matchList = PremierLeagueManager.getInstance().getMatchList();
        Collections.sort(matchList, new MatchDateCompare());
        return matchList;
    }

    public List<Match> searchedMatchData(int year, int month, int day) {
        List<Match> matchList = new ArrayList<>();
        try {
            Date date = new Date(year, month, day);
            for (Match match : PremierLeagueManager.getInstance().getMatchList()) {
                if (match.getDate().equals(date)) {
                    System.out.println("ad");
                    matchList.add(match);
                }
            }
        } catch (Exception e) {
            System.out.println("some thing went wong");
        }
        return matchList;
    }

}
