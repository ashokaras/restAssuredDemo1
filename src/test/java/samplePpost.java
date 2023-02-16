
 import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

 import io.restassured.RestAssured;
 import io.restassured.http.ContentType;
 import io.restassured.http.Cookie;
 import io.restassured.response.Response;
 import org.codehaus.groovy.runtime.powerassert.Value;
 import org.json.simple.JSONObject;
import org.testng.annotations.Test;

 import java.security.Key;
 import java.util.Date;
 import java.util.HashMap;
import java.util.Map;

public class samplePpost {


//        @Test
//        public void main(){
//            Response SaveResponse= get("https://reqres.in/api/users");
//            System.out.println("Res_body:"+SaveResponse.getBody().asPrettyString());
//            System.out.println("StatusCode:"+SaveResponse.getStatusCode());
//        }
//        @Test
//        public void  test_2(){
//            baseURI="https://reqres.in/";
//            given().get("api/users?page=2").then().statusCode(200).body("data.id[1]",equalTo(8));


    //}
    @Test
    public void post() {
        JSONObject userPayload = new JSONObject();
        String userName = "automationcorpadmin";
         try {

             userPayload.put("Language", "en");
             userPayload.put("Password", "Disprz@2020");
             userPayload.put("SessionIdentifier", new Date().getTime());
             userPayload.put("UserName", userName);
             userPayload.put("authManager", 1);
             userPayload.put("clientIdentifier", "");
             userPayload.put("deviceId", "");
             userPayload.put("deviceNotificationId", "");
             userPayload.put("deviceType", "");
         }


            catch (Exception e){
                e.printStackTrace();
            }

        RestAssured.baseURI = "https://qawaf.disprz.com";

        Response response = RestAssured.
                given().
                contentType(ContentType.JSON).
                when().
                body(userPayload.toJSONString()).
                post("/api/account/signin").
                then().
                extract().
                response();
        System.out.println("Reponse:" + response.asString());
        System.out.println("Reponse status code:" + response.getStatusCode());



}
@Test
    public void Create(){
    JSONObject createUser = new JSONObject();
    createUser.put("userId", "0");
    createUser.put("userName", "platformuser63523");
    createUser.put("firstName", "platformuser");
    createUser.put("lastName", "");
    createUser.put("password", "qwe");
    createUser.put("userStatus", "1");
    createUser.put("contexts", "[2]");
    createUser.put("userFullName", "platformuser ");


    JSONObject createUserHeader = new JSONObject();
    //   createUserHeader.put("Cookie","_hjSessionUser_2032617=eyJpZCI6ImRkZTQzNjYyLThlYjItNWNkNS04NTFmLTg0NWUzNzJmY2I2MyIsImNyZWF0ZWQiOjE2Njk2OTkxNjIyMTIsImV4aXN0aW5nIjpmYWxzZX0=; intercom-device-id-qtlvtba3=98200fed-7dc0-4297-b1d2-4ed08232084c; accessToken=yRxeW0VB3uvyFTFq+eGoqX91iZtWKfHYnNXEJzrAICYoP/mfTb6cpYCilIMSvRMlhHQLFxXVrL6LVRXd/XaBSIPUDW45QrUc9elHUD9fWlHBUmEdry+ldlzrCS0qIKTk7R39B5iJAsCBBuzAT4thIHOUGiPrrkLRkh4ST3BoL9Nnj05wqvXeyxvWq8xoLVZmhTmLeU5FvKIjTedvs38jXgD+6jB1W6FovE/Tx/oO1vOvedUWANGlviIDq7Hr97duj5hLQLtGbYH5SMdYtqNjwMJWuxRUQMcxsE8BBdEEHv0IXkuOE7fT5lIduktfiEGFn9tyuQVYZ4CpX1gV0cFu9ujGQatcw+ASCDSH8Ip7Sosoj+LuVD6A/NkWU8ysMtIa");
//    createUserHeader.put("sid","BapMY7u0PKE1LYb9TsZpyw==");
    RestAssured.baseURI = "https://qawaf.disprz.com";
    String cookie = "_hjSessionUser_2032617=eyJpZCI6ImRkZTQzNjYyLThlYjItNWNkNS04NTFmLTg0NWUzNzJmY2I2MyIsImNyZWF0ZWQiOjE2Njk2OTkxNjIyMTIsImV4aXN0aW5nIjpmYWxzZX0=; intercom-device-id-qtlvtba3=98200fed-7dc0-4297-b1d2-4ed08232084c; accessToken=yRxeW0VB3uvyFTFq+eGoqX91iZtWKfHYnNXEJzrAICYoP/mfTb6cpYCilIMSvRMlhHQLFxXVrL6LVRXd/XaBSIPUDW45QrUc9elHUD9fWlHBUmEdry+ldlzrCS0qIKTk7R39B5iJAsCBBuzAT4thIHOUGiPrrkLRkh4ST3BoL9Nnj05wqvXeyxvWq8xoLVZmhTmLeU5FvKIjTedvs38jXgD+6jB1W6FovE/Tx/oO1vOvedUWANGlviIDq7Hr97duj5hLQLtGbYH5SMdYtqNjwMJWuxRUQMcxsE8BBdEEHv0IXkuOE7fT5lIduktfiEGFn9tyuQVYZ4CpX1gV0cFu9ujGQatcw+ASCDSH8Ip7Sosoj+LuVD6A/NkWU8ysMtIa";
    String Sid="BapMY7u0PKE1LYb9TsZpyw==";
    String Orgin="https://platformqa.disprz.com";

    Response response =RestAssured.
            given().
            contentType(ContentType.JSON).
            header("Cookie",cookie).
            header("sid",Sid).
            header("Origin",Orgin).
            when().

            body(createUser.toJSONString()).
            post("/api/user/saveUser").
            then().
            extract().
            response();
    System.out.println("Reponse:" + response.asString());
    System.out.println("Reponse status code:" + response.getStatusCode());






}
}

