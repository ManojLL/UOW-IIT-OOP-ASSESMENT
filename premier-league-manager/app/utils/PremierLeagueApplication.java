package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import leagueManagers.PremierLeagueManager;
import play.libs.Json;

public class PremierLeagueApplication {
    public static ObjectNode createResponse(Object response, boolean ok) {
        ObjectNode result = Json.newObject();
        result.put("status", ok);
        if (response instanceof String)
            result.put("response", (String) response);
        else result.set("response", (JsonNode) response);

        return result;
    }

    public static void loaData(){
        if(PremierLeagueManager.getInstance().getClubCount() == 0) PremierLeagueManager.getInstance().loadData();
    }
}
