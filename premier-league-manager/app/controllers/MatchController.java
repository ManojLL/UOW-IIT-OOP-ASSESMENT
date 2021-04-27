package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.match.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.MatchService;
import utils.PremierLeagueApplication;
import java.util.List;

public class MatchController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("MatchController");

    // get matches according to dates (defending order)
    public Result getMatchAccordingToDate() {
        System.out.println(">>> get matches according to date");
        List<Match> matchList = MatchService.getInstance().matchesAccordingToDate();
        logger.debug("In MatchController.getMatchAccordingToDate(), result is: {}", matchList.toString());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(matchList, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }

    // generate a random match
    public Result createMatch() {
        System.out.println(">>> create random match");
        Match match = MatchService.getInstance().createNewMatch();
        if (match == null) {
            return badRequest(PremierLeagueApplication.createResponse("no clubs to make a match", false));
        }
        logger.debug("In MatchController.createMatch(), result is: {}", match.toString());
        JsonNode jsonObject = Json.toJson(match);
        return ok(PremierLeagueApplication.createResponse(jsonObject, true));
    }

    // search matches on specific date
    public Result searchMatches(int year, int month, int day) {
        System.out.println(">>> searching matches");
        List<Match> list = MatchService.getInstance().searchedMatchData(year, month, day);
        if (list.size() == 0) {
            return notFound(PremierLeagueApplication.createResponse("match not found", false));
        }
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonData = mapper.convertValue(list, JsonNode.class);
        return ok(PremierLeagueApplication.createResponse(jsonData, true));
    }
}
