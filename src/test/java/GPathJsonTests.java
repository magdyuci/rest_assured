import config.FootballConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.get;

public class GPathJsonTests extends FootballConfig {
    @Test
    public void extractMapOfElementsWithFind() {
        Response response = get("competitions/2021/teams");
        Map<String, ?> allTeamDataForSingleTeam = response.path("teams.find {it.name == 'Manchester United FC'}");
        System.out.println(allTeamDataForSingleTeam);
    }

    @Test
    public void extractSingleValueWithFind() {
        Response response = get("teams/57");
        String certainPlayer = response.path("squad.find { it.shirtNumber == 23}.name");
        System.out.println("Name of player = " + certainPlayer);
    }

    @Test
    public void extractListOfValueWithFindAll() {
        Response response = get("teams/57");
        List<String> certainPlayer = response.path("squad.findAll { it.shirtNumber == null}.name");
        System.out.println("List of player = " + certainPlayer);
    }

    @Test
    public void extractSingleMaxValue() {
        Response response = get("teams/57");
        String certainPlayer = response.path("squad.max { it.id }.name");
        System.out.println("Max number = " + certainPlayer);
    }

    @Test
    public void extractSingleMinValue() {
        Response response = get("teams/57");
        String certainPlayer = response.path("squad.min { it.id }.name");
        System.out.println("Min number = " + certainPlayer);
    }

    @Test
    public void extractMultipleValuesAndSum() {
        Response response = get("teams/57");
        int idSum = response.path("squad.collect { it.id }.sum()");
        System.out.println("Sum all id = " + idSum);
    }

    @Test
    public void extractMapOfObjectWithFindAndFindAll() {
        Response response = get("teams/57");
        Map<String, ?> playerOfCertainPosition = response.path("squad.findAll { it.position == 'Defender' }.find { it.nationality == 'Greece' }");
        System.out.println("Details of players " + playerOfCertainPosition);
    }

    @Test
    public void extractMapOfObjectWithFindAndFindAllWithParameters() {
        String position = "Defender";
        String nationality = "Greece";
        Response response = get("teams/57");
        Map<String, ?> playerOfCertainPosition = response.path("squad.findAll { it.position == '%s' }.find { it.nationality == '%s' }", position, nationality);
        System.out.println("Details of players " + playerOfCertainPosition);
    }

    @Test
    public void extractMapOfObjectWithFindAndFindAllWithParametersMultiplePlayers() {
        String position = "Midfielder";
        String nationality = "England";
        Response response = get("teams/57");
        ArrayList<Map<String, ?>> playersOfCertain = response.path("squad.findAll { it.position == '%s' }.findAll { it.nationality == '%s' }", position, nationality);
        System.out.println("All players " + playersOfCertain);
    }
}
