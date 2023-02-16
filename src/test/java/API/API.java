package API;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import org.json.JSONObject;
import payload.loginPayload;

import java.util.HashMap;

public class API {

    loginPayload userPayload = new loginPayload();

    String base_URI = "https://qawaf.disprz.com";


    String accessToken = "";
    String SID = "";
    String headerCookie = "";

    Cookies cookie=null;

    public String loginAPi(String userName, String password) {


        RestAssured.baseURI = base_URI;
        Response response = RestAssured.
                given().
                contentType(ContentType.JSON).
                when().
                body(userPayload.payload(userName, password)).
                post("/api/account/signin").
                then().
                extract().
                response();
        System.out.println(response.getBody().asString());
        headerCookie = response.getHeader("Cookie");
        this.cookie=response.getDetailedCookies();
        System.out.println("headerCookie " + headerCookie);
        JSONObject temp = new JSONObject(response.getBody().asString());
        this.accessToken = temp.getString("accessToken");
        this.SID = temp.getString("sid") + "==";
        System.out.println("acc: " + this.accessToken);
        System.out.println("sid: " + this.SID);
        //JSONObject accesstoken = new JSONObject(response.getBody().asString());
//            HashMap<String, String> hash = new  HashMap<String, String>();
//            hash.put("AccessToken", this.accessToken);
//            hash.put("Sid", this.SID);


//        System.out.println("Cookie" + response.getHeader("Set-Cookie"));
//        System.out.println("Reponse:" + response.asString());
//        System.out.println("Reponse status code:" + response.getStatusCode());
        return response.toString();

    }

    public void createUser(String newUserName, String newPassword) {
//        String cookie=this.accessToken;
//        String Sid=this.SID;
        String Orgin = "Origin: https://platformqa.disprz.com";
        System.out.println("createaccess :" + accessToken);
        System.out.println("Created :" + SID);
        Response response = RestAssured.
                given().
                contentType(ContentType.JSON).
                cookies(this.cookie).
                header("Origin", Orgin).
                when().

                body(userPayload.userCreationPayload(newUserName, newPassword)).
                post("/api/user/saveUser").
                then().
                extract().
                response();
        System.out.println("Reponse:" + response.asString());
        System.out.println("Reponse status code:" + response.getStatusCode());


    }
}
