package services;

import entities.clubs.FootballClub;
import entities.clubs.SportClub;
import entities.date.Date;
import entities.match.Match;
import leagueManagers.PremierLeagueManager;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CliService {

    private static CliService cliService;

    public static CliService getCliService() {
        if (cliService == null) {
            return new CliService();
        }
        return cliService;
    }

    public void addClub() {
        try {
            while (exit()) {
                Scanner sc = new Scanner(System.in);
                System.out.println("--------------------------------------------------------------");
                System.out.println("\t\t\t\t\tADDING CLUB TO LEAGUE");
                System.out.println("--------------------------------------------------------------");
                System.out.println("* MAXIMUM 20 CLUBS");
                System.out.println("\n==============================================================");
                System.out.println("* pro league club count : " + PremierLeagueManager.getInstance().getClubCount());
                System.out.println("==============================================================\n");
                //adding club to pro league
                //check is there is a space to adda club
                if (!(PremierLeagueManager.getInstance().getClubCount() < 20)) {
                    System.out.println("==============================================================");
                    System.out.println(">>> NO SPACE ADD A CLUB");
                    System.out.println("==============================================================");
                    break;
                }
                System.out.print(">>> Enter club name :");
                String clubName = sc.nextLine();

                /*
                 * validate the name the user given
                 * the club name is unique
                 * adding club according to league
                 * */

                if (validateName(clubName, PremierLeagueManager.getInstance().getFootballClubsList())) {
                    System.out.print(">>> Enter club location :");
                    String clubLocation = sc.nextLine();
                    SportClub footBallClub = new FootballClub(clubName, clubLocation);
                    if (PremierLeagueManager.getInstance().addClubToLeague(footBallClub))
                        System.out.println("> " + clubName + " club added pro-football league");
                } else {
                    System.out.println("* this club has already added to league");
                }
            }
        } catch (Exception e) {
            System.out.println("some went wrong ");
        }

    }

    private boolean validateName(String name, List<FootballClub> leagueFootballClub) {
        try {
            for (FootballClub footBallClub : leagueFootballClub) {
                //check the name's validity
                if (footBallClub.getClubName().equals(name)) {
                    //if name has already used return false
                    return false;
                }
            }
        } catch (Exception e) {
            System.out.println("some thing went wrong");
        }
        return true;
    }

    private boolean exit() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("# if you want to exit press Q otherwise press any key");
        System.out.print("\n>>> enter option : ");
        String option = sc.next().toLowerCase();
        System.out.println();
        return (!option.equals("q"));
    }

    //delete club from league
    public void deleteClub() {
        while (exit()) {

            // check is pro-league list containing club if not then continue
            if (!(PremierLeagueManager.getInstance().getClubCount() > 0)) {
                System.out.println("no clubs in pro-league");
                continue;
            }

            //select a club from the league
            FootballClub proClub = selectAClub(PremierLeagueManager.getInstance().getFootballClubsList());

            // delete the club from league
            if (PremierLeagueManager.getInstance().deleteSportClub(proClub))
                System.out.println(proClub.getClubName() + " delete from the league");
        }
    }

    /*
     * this method id used sho the club list
     * @param leagueList = club list of the league
     */
    private void showClubList(List<FootballClub> leagueList) {
        System.out.println("--------------------------------------------------------------");
        System.out.println("\t\t\t\t CLUB LIST");
        System.out.println("--------------------------------------------------------------");
        int index = 0;
        if (leagueList.size() > 0) {
            System.out.println("--------------------------------------------------------------\n");
            for (FootballClub f : leagueList) {
                System.out.println(index + 1 + " => " + f.getClubName());
                index++;
            }
            System.out.println("--------------------------------------------------------------\n");
        }
    }

    /*
     * this method is used to select a club from given league club list
     * @param leagueList = club list in the league typr
     * @return this return a FootballClub
     */
    private FootballClub selectAClub(List<FootballClub> leagueList) {
        while (true) {
            try {
                //show the club list
                showClubList(leagueList);
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter a club number : ");
                int clubNumber = sc.nextInt();
                //check user input is valid
                if (clubNumber > 0 && clubNumber <= leagueList.size()) {
                    //get the football club from give list and return it
                    return leagueList.get(clubNumber - 1);
                } else {
                    System.out.println("your entered number not valid ");
                }
            } catch (InputMismatchException e) {
                System.out.println("use only numbers ");
            }
        }
    }

    public void displayClubStats() {
        while (exit()) {

            //pro league sector
            //check is the list empty
            if (!(PremierLeagueManager.getInstance().getClubCount() > 0)) {
                System.out.println("no clubs in pro-league");
                continue;
            }
            //select a club and display its stats
            PremierLeagueManager.getInstance().displayStatsOfClub(selectAClub(PremierLeagueManager.getInstance().getFootballClubsList()));
        }
    }


    public void displayLeagueTable() {
        while (exit()) {

            //pro league section
            // check clubs in list
            if (!(PremierLeagueManager.getInstance().getClubCount() > 0)) {
                System.out.println("no clubs in pro-league");
                continue;
            }
            //show the club after the sort
            PremierLeagueManager.getInstance().displayLeagueTable();
        }
    }


    /*
     * this method used to add played match details
     * */
    public void createMatch() {
        try {
            //pro league
            //add matching details
            addMatchDetails(PremierLeagueManager.getInstance().getFootballClubsList());

        } catch (Exception e) {
            System.out.println("Some thing went wrong ");
        }
    }

    /*
     * this method use to check is the more than one club to c=make a match
     * @param list club list
     * @param pm premier league Manager
     */
    private void addMatchDetails(List<FootballClub> list) {
        //check is there enough clubs to make a match
        if (list.size() >= 2) {
            //make match
            PremierLeagueManager.getInstance().addMatch(addAMatch(list));
        } else {
            System.out.println("no more teams to create a match");
        }
    }

    /*
     * this method used to get match details manually
     * @param list league club list
     * @return this return match
     */
    private Match addAMatch(List<FootballClub> list) {
        while (true) {
            try {
                //select club according to the lague
                FootballClub teamA = selectAClub(list);
                FootballClub teamB = selectAClub(list);

                // checking selected clubs are same
                while ((teamA.equals(teamB))) {
                    System.out.println("you have choose same team ");
                    teamB = selectAClub(list);
                }
                //get clubs scored goals
                int teamAGoals = getGoals("team A");
                int teamBGoals = getGoals("team B");
                //get the date
                Date date = addDate();

                //find the winner
                String status = "";
                if (teamAGoals > teamBGoals) {
                    status = "> " + teamA.getClubName() + " has won the match ";
                    System.out.println(status);
                } else if (teamBGoals > teamAGoals) {
                    status = "> " + teamB.getClubName() + " has won the match ";
                    System.out.println(status);
                } else {
                    status = "> Match has draw";
                    System.out.println(status);
                }
                //return the match
                return (new Match(teamA, teamB, date, teamAGoals, teamBGoals, status));

            } catch (Exception e) {
                System.out.println("some thing went wrong");
            }
        }
    }

    /*
     * this method use to get valid input from user
     * @param teamName club name
     * @return return goal team scored
     */
    private int getGoals(String teamName) {
        while (true) {
            try {
                //get goal club has scored as int
                Scanner sc = new Scanner(System.in);
                System.out.print("enter " + teamName + " goals : ");
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("enter only numbers !!");
            }
        }
    }

    //add date
    public Date addDate() {
        System.out.println("add a date");
        System.out.print("enter year : ");
        int year = validateYear();
        int month = validateDates(12, "month");
        int day = validateDates(31, "day");
        return new Date(year, month, day);
    }

    private int validateYear() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("enter year : ");
                int date = sc.nextInt();
                Date today = PremierLeagueManager.getInstance().getCurrentDate();
                //validate the year using current date
                if (!(date <= today.getYear() && date >= today.getYear() - 1)) {
                    System.out.println("* wrong year pla");
                } else {
                    return date;
                }
            } catch (InputMismatchException e) {
                System.out.println("use numbers only");
            }
        }
    }

    private int validateDates(int max, String s) {

        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("enter " + s + " : ");
                int date = sc.nextInt();
                if (!(date <= max && date >= 1)) {
                    System.out.println("wrong input>>>");
                } else {
                    return date;
                }
            } catch (InputMismatchException e) {

                System.out.println("use numbers only");
            }
        }
    }
}
