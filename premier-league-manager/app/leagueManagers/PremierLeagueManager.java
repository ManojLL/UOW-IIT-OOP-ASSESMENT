package leagueManagers;

import entities.clubs.FootballClub;
import entities.clubs.SportClub;
import entities.date.Date;
import entities.match.Match;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PremierLeagueManager implements LeagueManager {
    private static final int MAX_COUNT = 20;
    private static final int WIN_POINT = 2;
    private static final int DEFEAT_POINT = 0;
    private static final int DRAW_POINT = 1;
    private static final String CLUB_FILE_PATH = "gvjvjk";
    private static final String MATCH_FILE_PATH = "gvjvjk";
    private List<FootballClub> footballClubsList = new ArrayList<>(MAX_COUNT);
    private List<Match> matchList = new ArrayList<>();
    private static PremierLeagueManager instance;
    private static int clubCount = 0;

    private PremierLeagueManager() {
    }

    public static PremierLeagueManager getInstance() {
        if (instance == null) {
            synchronized (PremierLeagueManager.class) {
                instance = new PremierLeagueManager();
            }
        }
        return instance;
    }

    @Override
    public boolean addClubToLeague(SportClub sportClub) {
        try {
            if (clubCount == 20 || !(sportClub instanceof FootballClub)) return false;
            for (FootballClub footballClub : footballClubsList) {
                if (footballClub.equals(sportClub)) return false;
            }
            footballClubsList.add((FootballClub) sportClub);
            clubCount++;
            return true;
        } catch (Exception e) {
            System.out.println("The programme went wrong");
        }
        return false;
    }

    @Override
    public boolean deleteSportClub(SportClub sportClub) {
        try {
            if (!(sportClub instanceof FootballClub)) return false;
            FootballClub footballClub = (FootballClub) sportClub;
            footballClubsList.remove(footballClub);
            clubCount--;
            return true;
        } catch (Exception e) {
            System.out.println("programme went wrong");
        }
        return false;
    }

    @Override
    public void displayStatsOfClub(SportClub sportClub) {
        try {
            if (sportClub instanceof FootballClub) {
                FootballClub footballClub = (FootballClub) sportClub;
                System.out.println("number of played match : " + footballClub.getNumOfPlayedMatch());
                System.out.println("number of wins : " + footballClub.getNumOfWin());
                System.out.println("number of defeat : " + footballClub.getNumOfDefeat());
                System.out.println("number of draws : " + footballClub.getNumOfDraw());
                System.out.println("number of scored goals : " + footballClub.getScoredGoal());
                System.out.println("number of received goals : " + footballClub.getReceivedGoal());
                System.out.println("season points : " + footballClub.getPoint());
            }
        } catch (Exception e) {
            System.out.println("Programme went wrong");
        }
    }

    @Override
    public void displayLeagueTable() {
        try {
            if (clubCount > 0) {
                int index = 1;
                Collections.sort(footballClubsList);
                for (FootballClub footballClub : footballClubsList) {
                    System.out.println(index + " >>" + footballClub.getClubName() + "\t" + footballClub.getPoint());
                    index++;
                }
            }
        } catch (Exception e) {
            System.out.println("programme went wrong");
        }
    }

    @Override
    public void addMatch(Match match) {
        try {
            matchList.add(match);
            FootballClub teamA = match.getTeamA();
            FootballClub teamB = match.getTeamB();
            teamA.setNumOfPlayedMatch();
            teamB.setNumOfPlayedMatch();
//            teamA.setMatchList(match);
//            teamB.setMatchList(match);
            teamA.setScoredGoal(match.getTeamAScore());
            teamA.setReceivedGoal(match.getTeamBScore());
            teamB.setScoredGoal(match.getTeamBScore());
            teamB.setReceivedGoal(match.getTeamAScore());
            if (match.getTeamAScore() == match.getTeamBScore()) {
                teamA.setNumOfDraw();
                teamB.setNumOfDraw();
                teamA.setPoint(DRAW_POINT);
                teamB.setPoint(DRAW_POINT);
            } else if (match.getTeamAScore() < match.getTeamBScore()) {
                teamA.setNumOfDefeat();
                teamA.setPoint(DEFEAT_POINT);
                teamB.setNumOfWin();
                teamB.setPoint(WIN_POINT);
            } else {
                teamB.setNumOfDefeat();
                teamB.setPoint(DEFEAT_POINT);
                teamA.setNumOfWin();
                teamA.setPoint(WIN_POINT);
            }

        } catch (Exception e) {
            System.out.println("Programme went wrong");
        }
    }

    @Override
    public void saveData() {

    }

    @Override
    public void loadData() {

    }

    public List<FootballClub> getFootballClubsList() {
        return this.footballClubsList;
    }

    public List<Match> getMatchList() {
        return this.matchList;
    }

    // get current date
    public Date getCurrentDate() {
        LocalDate date = LocalDate.now();
        String[] date2 = date.toString().split("-");
        return new Date(Integer.parseInt(date2[0]), Integer.parseInt(date2[1]), Integer.parseInt(date2[2]));
    }

    public FootballClub getRandomClub() {
        /*
         * randomly get  a number between 0 and size of the clubList
         * then get  club according to that random number*/
        int index = new Random().nextInt(footballClubsList.size());
        return footballClubsList.get(index);
    }

    public int getClubCount() {
        return clubCount;
    }
}
