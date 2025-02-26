import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.hamcrest.core.IsEqual.equalTo;

public class EchoTest {


    @Test
    public void getTest() {
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .log().all()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .log().all();
    }

    @Test
    public void postTest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));

    }

    @Test
    public void postTestTwo() {
        RestAssured.baseURI = "https://postman-echo.com";
        String bodyRequest = "{ \"foo1\": \"bar1\", \"foo2\": \"bar2\" }";
        given()
                .header("Content-Type", "application/json")
                .body(bodyRequest)
                .when().post("/post")
                .then()
                .statusCode(200)
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"));


    }

    @Test
    public void putTest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().put("/put")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }

    @Test
    public void patchTest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when().patch("/patch")
                .then()
                .statusCode(200)
                .body("data", equalTo("This is expected to be sent back as part of response body."));
    }
    @Test
    public void deleteTest(){
        String requestBody = "This is expected to be sent back as part of response body.";
        RestAssured.baseURI = "https://postman-echo.com";
        given()
                .header("Content-Type","application/json")
                .body(requestBody)
                .when().delete("/delete")
                .then()
                .statusCode(200)
                .body("data",equalTo("This is expected to be sent back as part of response body."));
    }
}

