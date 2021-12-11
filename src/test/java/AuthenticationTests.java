import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthenticationTests {
    @BeforeClass
    public static void setup() {
        RestAssured.proxy("localhost", 8888);
    }

    @Test
    public void basicPreemptiveAuthTest() {
        given().auth().preemptive().basic("username", "password").
                when().get("http://localhost:8080/someEndpoint");
    }

    @Test
    public void basicChallengedAuthTest() {
        given().auth().basic("username", "password").
                when().get("http://localhost:8080/someEndpoint");
    }
}
