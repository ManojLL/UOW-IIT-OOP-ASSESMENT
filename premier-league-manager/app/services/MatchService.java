package services;

import entities.clubs.FootballClub;
import entities.date.Date;
import entities.match.Match;
import leagueManagers.PremierLeagueManager;
import leagueManagers.supportClasses.MatchDateCompare;
import utils.ApplicationIO;
import java.util.*;

public class MatchService {
    private static MatchService premierLeagueService;

    private MatchService() {
    }

    public synchronized static MatchService getInstance() {
        ApplicationIO.loadMatchData();
        ApplicationIO.loadClubData();
        if (premierLeagueService == null) {
            premierLeagueService = new MatchService();
        }
        return premierLeagueService;
    }

    // create a random match
    public synchronized Match createNewMatch() {
        try {
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
        }catch (ConcurrentModificationException e){
            createNewMatch();
        }
        return null;
    }

    // get a football clubs
    // check it
    private synchronized FootballClub getClub(FootballClub teamA, FootballClub teamB) {
        while (teamA.equals(teamB)) {
            teamB = PremierLeagueManager.getInstance().getRandomClub();
        }
        return teamB;
    }

    // generate random number between 0- 10
    private synchronized int getGoals() {
        return new Random().nextInt(10);
    }

    // sort the matches according to date
    public synchronized List<Match> matchesAccordingToDate() {
        List<Match> matchList = PremierLeagueManager.getInstance().getMatchList();
        Collections.sort(matchList, new MatchDateCompare());
        return matchList;
    }

    // search match according to date
    public synchronized List<Match> searchedMatchData(int year, int month, int day) {
        List<Match> matchList = new ArrayList<>();
        try {
            Date date = new Date(year, month, day);
            for (Match match : PremierLeagueManager.getInstance().getMatchList()) {
                if (match.getDate().equals(date)) {
                    matchList.add(match);
                }
            }
        } catch (Exception e) {
            System.out.println("some thing went wong");
        }
        return matchList;
    }

}
