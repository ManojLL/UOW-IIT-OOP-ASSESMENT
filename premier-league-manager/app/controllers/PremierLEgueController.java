package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.clubs.FootballClub;
import entities.match.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.MatchService;
import services.PremierLEagueService;
import services.TableService;
import utils.PremierLeagueApplication;

import java.util.List;

public class PremierLEgueController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("TableController");

    public Result getLeagueTableAccordingToPoints() {
        List<FootballClub> footballClubList = PremierLEagueService.getPremierLEagueService().leagueTableAccordingToPoints();
        logger.debug("In TableController.getLeagueTableAccordingToPoints(), result is: {}", footballClubList.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(footballClubList, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }

    public Result getLeagueTableAccordingToWins() {
        List<FootballClub> footballClubList = PremierLEagueService.getPremierLEagueService().leagueTableAccordingToNumOfWins();
        logger.debug("In TableController.getLeagueTableAccordingToWins(), result is: {}", footballClubList.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(footballClubList, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }

    public Result getLeagueTableAccordingToGoals() {
        List<FootballClub> footballClubList = PremierLEagueService.getPremierLEagueService().leagueTableAccordingToNumOfGoals();
        logger.debug("In TableController.getLeagueTableAccordingToGoals(), result is: {}", footballClubList.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(footballClubList, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }

    public Result getMatchAccordingToDate(){
        List<Match> matchList = PremierLEagueService.getPremierLEagueService().matchesAccordingToDate();
        logger.debug("In MatchController.getMatchAccordingToDate(), result is: {}", matchList.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(matchList, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }

    public Result createMatch(){
        Match match = PremierLEagueService.getPremierLEagueService().createNewMatch();
        if (match == null) {
            return badRequest(PremierLeagueApplication.createResponse("no clubs to make a match", false));
        }
        logger.debug("In MatchController.createMatch(), result is: {}", match.toString());
        JsonNode jsonObject = Json.toJson(match);
        return ok(PremierLeagueApplication.createResponse(jsonObject, true));
    }
}
