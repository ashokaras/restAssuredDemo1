import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class APITest {


    @Test
    public void main(){
      Response SaveResponse= get("https://reqres.in/api/users");
        System.out.println("Res_body:"+SaveResponse.getBody().asPrettyString());
        System.out.println("StatusCode:"+SaveResponse.getStatusCode());
    }
    @Test
    public void  test_2(){
        baseURI="https://reqres.in/";
        given().get("api/users?page=2").then().statusCode(200).body("data.id[1]",equalTo(8));



    }
    @Test
    public void post(){
        JSONObject userPayload = new JSONObject();
        userPayload.put("name","Anwar");
        userPayload.put("job","QA Engineer");

        baseURI="https://reqres.in/";
        given().
                body(userPayload.toJSONString()).
                when().
                post("api/users").
                then().statusCode(201).extract().response();



    }
}
