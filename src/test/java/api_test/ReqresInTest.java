package api_test;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ReqresInTest {
    @Test
    public void getStatusReqresInTest(){
        given().when().get("https://reqres.in/api/users/2").then().statusCode(200);
    }

    @Test
    public void firstNameReqresInTest(){
        Response response = given().when().get("https://reqres.in/api/users/2").then().statusCode(200)
                .extract().response();
        String name = response.path("data.first_name");
        Assertions.assertEquals("Janet",name);
    }
}
