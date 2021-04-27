import leagueManagers.PremierLeagueManager;
import services.CliService;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;

public class CliApplication {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("=============================================================");
        System.out.println("                WESTMINSTER PRIMER LEAGUE");
        System.out.println("=============================================================");
        System.out.println("welcome !! ");

        // create a new season or load previous saved data
        CliService.getCliService().createNewSeason();

        System.out.println("# starting the server ...");

        // starting server
        Process commandsRunner = null;
        String currentRoot = null;
        try {
            // get the current root directory path
            currentRoot = new File("../").getCanonicalPath();
            ProcessBuilder pb = new ProcessBuilder();
            // running some bash scripts
            pb.command("bash", "-c", "target/universal/stage/bin/premier-league-manager").directory(new File(currentRoot));
            commandsRunner = pb.start();
        } catch (Exception e) {
            System.out.println("~~~~~~~~~  can not start the server ~~~~~~~~~");
        }
        menu:
        while (true) {
            System.out.println("----------------------   main menu   -------------------------");
            System.out.println("==============================================================\n");
            System.out.println("||   1 = Create and add a club to primerLeague\t\t\t||");
            System.out.println("||   2 = Delete club from primerLeague\t\t\t\t||");
            System.out.println("||   3 = Show select club statics\t\t\t\t||");
            System.out.println("||   4 = Show primerLeague table according to points\t\t||");
            System.out.println("||   5 = Add played match manually\t\t\t\t||");
            System.out.println("||   6 = open the gui\t\t\t\t\t\t||");
            System.out.println("||   7 = exit\t\t\t\t\t\t\t||");
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
                case "6":
                    System.out.println("# saving data");
                    // save the data before get data from API
                    PremierLeagueManager.getInstance().saveData();
                    CliService.getCliService().openTheBrowser();
                    System.out.println(">>> press any key to go to main menu");
                    String sc = userInput.next();
                    // load data into cli application
                    PremierLeagueManager.getInstance().loadData();
                    break;
                case "7":
                    System.out.println("# stopping the server .....");
                    // destroy the server
                    commandsRunner.destroy();
                    delete(currentRoot);
                    System.out.println("# saving data");
                    PremierLeagueManager.getInstance().saveData();
                    System.out.println("# exiting .........");
                    break menu;
                default:
                    System.out.println("...... WRONG INPUT ......");
            }
        }
    }

    // this method is used to delete logs before exiting
    private static void delete(String rootPath) {
        try {
            Files.deleteIfExists(Paths.get(rootPath + "/target/universal/stage/RUNNING_PID"));
        } catch (NoSuchFileException e) {
            System.out.println("No such file/directory exists");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("Directory is not empty.");
        } catch (IOException e) {
            System.out.println("Invalid permissions.");
        }
        System.out.println("the log file deletion successful.");
    }

}

