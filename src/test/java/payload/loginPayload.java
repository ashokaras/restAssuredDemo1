package payload;

import io.restassured.response.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Date;
import java.util.HashMap;

public class loginPayload {
    public String payload(String username, String password) {

        JSONObject userPayload = new JSONObject();
        userPayload.put("Language", "en");
        userPayload.put("Password", password);
        userPayload.put("SessionIdentifier", new Date().getTime());
        userPayload.put("UserName", username);
        userPayload.put("authManager", 1);
        userPayload.put("clientIdentifier", "");
        userPayload.put("deviceId", "");
        userPayload.put("deviceNotificationId", "");
        userPayload.put("deviceType", "");

        return userPayload.toString();

    }

    public String userCreationPayload(String newUsername,String newPassword){


        JSONObject createUser = new JSONObject();
        createUser.put("userId", "0");
        createUser.put("userName", newUsername);
        createUser.put("firstName", newPassword);
        createUser.put("lastName", "");
        createUser.put("password", "qwe");
        createUser.put("userStatus", "1");
        createUser.put("contexts", "[2]");
        createUser.put("userFullName", "platformuser ");
        return createUser.toString();

    }







}
