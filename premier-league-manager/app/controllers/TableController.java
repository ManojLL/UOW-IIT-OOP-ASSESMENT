package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.clubs.FootballClub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.mvc.Controller;
import play.mvc.Result;
import services.TableService;
import utils.PremierLeagueApplication;

import java.util.List;

public class TableController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("TableController");

    // sort the league table according to points
    public Result getLeagueTableAccordingToPoints() {
        System.out.println(">>> get leader board according to points");
        List<FootballClub> footballClubList = TableService.getTableService().leagueTableAccordingToPoints();
        logger.debug("In TableController.getLeagueTableAccordingToPoints(), result is: {}", footballClubList.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(footballClubList, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }

    // sort the league table according to wins
    public Result getLeagueTableAccordingToWins() {
        System.out.println(">>> get leader board according to wins");
        List<FootballClub> footballClubList = TableService.getTableService().leagueTableAccordingToNumOfWins();
        logger.debug("In TableController.getLeagueTableAccordingToWins(), result is: {}", footballClubList.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(footballClubList, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }

    // sort the league table according to scored goals
    public Result getLeagueTableAccordingToGoals() {
        System.out.println(">>> get leader board according to goals");
        List<FootballClub> footballClubList = TableService.getTableService().leagueTableAccordingToNumOfGoals();
        logger.debug("In TableController.getLeagueTableAccordingToGoals(), result is: {}", footballClubList.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(footballClubList, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }

}
