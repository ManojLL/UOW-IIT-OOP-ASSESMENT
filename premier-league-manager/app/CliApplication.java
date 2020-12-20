import leagueManagers.PremierLeagueManager;
import services.CliService;

import java.util.Scanner;

public class CliApplication {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("                WESTMINSTER PRIMER LEAGUE");
        System.out.println("=============================================================");
        System.out.println("welcome !! \t\t\t\t\t");
        PremierLeagueManager.getInstance().loadData();
        menu:
        while (true) {
            System.out.println("----------------------   main menu   -------------------------");
            System.out.println("==============================================================\n");
            System.out.println("||   1 = Create and add a club to primerLeague\t\t\t\t||");
            System.out.println("||   2 = Delete club from primerLeague\t\t\t\t\t\t||");
            System.out.println("||   3 = Show select club statics\t\t\t\t\t\t\t||");
            System.out.println("||   4 = Show primerLeague table according to points\t\t||");
            System.out.println("||   5 = Add played match manually\t\t\t\t\t\t\t\t\t||");
            System.out.println("||   6 = open the gui\t\t\t\t\t\t\t\t\t||");
            System.out.println("||   7 = exit\t\t\t\t\t\t\t\t\t\t\t\t||");
            System.out.println("\n==============================================================\n");
            System.out.print(">>> Enter your option = ");
            String option = userInput.next().toLowerCase();
            switch (option) {
                case "1":
                    CliService.getCliService().addClub();
                    break;
                case "2":
                    CliService.getCliService().deleteClub();
                    break;
                case "3":
                    CliService.getCliService().displayClubStats();
                    break;
                case "4":
                    CliService.getCliService().displayLeagueTable();
                    break;
                case "5":
                    CliService.getCliService().createMatch();
                    break;
                case "7":
//                    CliService.getCliService().saveData();
                    System.out.println("exiting .........");
                    break menu;
                default:
                    System.out.println("...... WRONG INPUT ......");
            }
        }
    }
}
