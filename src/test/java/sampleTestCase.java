import API.API;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
//import org.testng.annotations;
import org.testng.annotations.Test;
import payload.loginPayload;

import java.util.HashMap;

import static io.restassured.RestAssured.baseURI;


public class sampleTestCase {
    loginPayload userPayload = new loginPayload();
    API disprzAPI = new API();
    String userName = "automationcorpadmin";
    String password = "admin";
    String newUsername = "anwar_restassured1";
    String newPassword = "qwe";

    @Test
    public void menu() {

//        HashMap<String, String> hash =
        disprzAPI.loginAPi(userName, password);
        System.out.println("success");

        disprzAPI.createUser(newUsername, newPassword);


    }
}
