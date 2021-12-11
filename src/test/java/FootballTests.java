import config.Endpoints;
import config.FootballConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FootballTests extends FootballConfig {
    @Test
    public void myFirstTest() {
        given().log().all().
                when().get("teams/18/").
                then().log().all();
    }

    @Test
    public void myFirstTestWithEndpointGiven() {
        given().log().all().
                when().get(Endpoints.ALL_TEAMS).
                then().log().all();
    }

    @Test
    public void myFirstTestWithEndpoint() {
        get(Endpoints.ALL_TEAMS)
                .then().log().all();
    }

    @Test
    public void getAreaDetails() {
        given().
                queryParam("areas", 2072).
                when().get("areas/");
    }

    //Assert the body of a HTTP Response
    @Test
    public void getDateFounded() {
        given().when().get("teams/57").then().body("founded", equalTo(1886));

    }

    @Test
    public void getFirstTeamName() {
        given().when().get("competitions/2021/teams").then().body("teams.name[0]", equalTo("Arsenal FC"));

    }

    //Extract the body of a HTTP Response
    @Test
    public void getAllTeamData() {
        String responseBody = get("teams/57").asString();
        System.out.println(responseBody);
    }

    @Test
    public void getAllTeamData_DoCheckFirst() {
        Response response =
                given().
                        when()
                        .get("teams/57")
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();
        String responseBody = response.asString();
    }

    //Extract the headers of a HTTP Response
    @Test
    public void extractHeaders() {
        Response response =
                given().
                        when()
                        .get("teams/57")
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        Headers headers = response.getHeaders();
        //specific header
        String contentType = response.getHeader("Content-Type");
        System.out.println(contentType);
    }

    //Extract explicit data from the body with JSON path
    @Test
    public void extractFirstTeamName() {
        String firstTeamName = get("competitions/2021/teams").jsonPath().getString("teams.name[0]");
        //This line return Arsenal FC
        System.out.println(firstTeamName);
    }

    @Test
    public void extractAllTeamNames() {
        Response response = given().when().get("competitions/2021/teams").then().extract().response();
        List<String> teamNames = response.path("teams.name");
        for (String teamName : teamNames) {
            //This line return all the team name list
            System.out.println(teamName);
        }
    }

    //Object Serialization
    @Test
    public void testFootballSerializationByJSON() {

    }
}
