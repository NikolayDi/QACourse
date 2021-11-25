import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Task_11 {
    @Test
    //get scenario with 200 status
    public void testGetUser() {
        given()
                .baseUri("https://reqres.in/")
                .pathParam("user_id", 2)
                .log().all()
                .get("api/users/{user_id}")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    //get scenario with 200 status
    public void testGetResource() {
        given()
                .baseUri("https://reqres.in/")
                .pathParam("resource_id", 2)
                .log().all()
                .get("api/resource/{resource_id}")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);
    }
    @Test
    //get scenario without 200
    public void testGetResourceNoteFound() {
        given()
                .baseUri("https://reqres.in/")
                .pathParam("resource_id", 23)
                .log().all()
                .get("api/resource/{resource_id}")
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
    @Test
    //post scenario
    public void testPostUsers() {
        String baseUri = "https://reqres.in/";
        String postUser = "/api/users";
        String testBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(testBody)
                .log().all()
                .post(postUser)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED);
    }
}
