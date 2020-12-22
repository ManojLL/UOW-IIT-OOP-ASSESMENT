package utils;

import leagueManagers.PremierLeagueManager;

public class ApplicationIO {
    private final static String MATCH_FILE_PATH = "public/matches.txt";
    private final static String CLUB_FILE_PATH = "public/club.txt";

    public static void loadClubData() {
            PremierLeagueManager.getInstance().getFootballClubsList().clear();
            PremierLeagueManager.getInstance().loadDataFromFile(CLUB_FILE_PATH, "clubs");
    }

    public static void loadMatchData() {
        PremierLeagueManager.getInstance().getMatchList().clear();
        PremierLeagueManager.getInstance().loadDataFromFile(MATCH_FILE_PATH, "matches");
    }

    public static void saveMatchData() {
        PremierLeagueManager.getInstance().saveToFile(PremierLeagueManager.getInstance().getMatchList(), MATCH_FILE_PATH);
    }

    public static void saveClubData() {
        PremierLeagueManager.getInstance().saveToFile(PremierLeagueManager.getInstance().getFootballClubsList(), CLUB_FILE_PATH);
    }

}
