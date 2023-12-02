package main.controllers;

import io.restassured.http.ContentType;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AuthControllerTest {

    private static final String username = "test01";
    private static final String password = "test01";
    JSONObject data = new JSONObject();

    @BeforeClass
    public void beforeClass(){
        try {
            data.put("username", username);
            data.put("password", password);
        } catch (JSONException e) {
            throw new RuntimeException(e);
            //TODO handle it
        }
    }

    @Test(priority = 1, description = "Checks if Signup endpoint is working")
    public void registerUserTest() {
        given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .when()
                .post("http://localhost:8080/api/auth/signup")
                .then()
                .statusCode(200)
                .body("message", equalTo("User registered successfully!"));
    }
    @Test(priority = 2, description = "Checks if Signup endpoint is working if data is already in database")
    public void registerExistingUserTest() {
        given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .when()
                .post("http://localhost:8080/api/auth/signup")
                .then()
                .statusCode(400)
                .body("message", equalTo("Username is already taken!"));
    }
    @Test(priority = 3, description = "Checks if login endpoint is working")
    public void authenticateUserTest() {
        given()
                .contentType(ContentType.JSON)
                .body(data.toString())
                .when()
                .post("http://localhost:8080/api/auth/login")
                .then()
                .statusCode(200)
                .body("token", notNullValue())
                .body("type", equalTo("Bearer"))
                .body("id", notNullValue())
                .body("username", equalTo(username))
                .body("roles", contains(equalTo("User")))
                .body("balance", notNullValue());
    }
}
