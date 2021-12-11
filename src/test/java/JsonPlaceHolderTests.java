import config.Endpoints;
import config.JsonPlaceHolderConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class JsonPlaceHolderTests extends JsonPlaceHolderConfig {

    @Test
    public void jasonPlaceHolderPost() {
        String jsonBody = "{\n" +
                "        \"userId\": 120,\n" +
                "        \"id\": 100,\n" +
                "        \"title\": \"This is the title\",\n" +
                "        \"body\": \"This is the body description\"\n" +
                "    }";
        given()
                .body(jsonBody).
                when()
                .post(Endpoints.ALL_TEAMS).
                then();
    }

    @Test
    public void getUsersJPH() {
        given().log().all().
                when().get(Endpoints.JSON_POSTS).then().log().all();
    }

    //Object Serialization-> for this test to run properly you need to include com.fasterxml.jackson.core in the pom.xml file
    @Test
    public void testJsonPlaceHolderSerializationByJSON() {
        JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder(20, "Games of Thrones", "It's a series where all people die", 1);
        given().
                body(jsonPlaceHolder).
                when().
                post(Endpoints.JSON_POSTS).
                then().body("title", equalTo("Games of Thrones"));
    }

    //Validating Response against a JSON Schema
    @Test
    public void testJsonPlaceHolderSchema() {
        given().
                when().
                get(Endpoints.JSON_SINGLE_POST).
                then().body(matchesJsonSchemaInClasspath("JsonPlaceHolderSchema.json"));
    }

    //Convert JSON Response to POJO
    @Test
    public void testConvertJsonToPojo() {
        Response response = given().
                when().
                get(Endpoints.JSON_SINGLE_POST);
        JsonPlaceHolder jsonPlaceHolder = response.getBody().as(JsonPlaceHolder.class);
        System.out.println(jsonPlaceHolder.toString());
    }

    //Measuring Response Time in REST Assured
    @Test
    public void captureResponseTime() {
        long responseTime = get(Endpoints.JSON_SINGLE_POST).time();
        System.out.println(responseTime);
    }

    @Test
    public void assertOnResponseTime() {
        when().
                get(Endpoints.JSON_SINGLE_POST).
                then().
                time(lessThan(1000L));
    }
}
