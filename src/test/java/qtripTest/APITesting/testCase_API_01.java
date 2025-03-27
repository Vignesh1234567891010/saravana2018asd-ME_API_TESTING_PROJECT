package qtripTest.APITesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.UUID;

public class testCase_API_01 extends BaseTest{

    private static String email;
    private  static String password;
    private static String token;
    private static String userID;
    private JSONObject jObject;

    @Test(priority = 1, enabled = true, groups = "API Tests")
    public void registerUser(){

        jObject = new JSONObject();

        email = "vicky"+ UUID.randomUUID().toString()+"@gmail.com";
        password = "password12";

        jObject.put("email", email);
        jObject.put("password", password);
        jObject.put("confirmpassword", password);

        Response regResp = given().log().all().contentType(ContentType.JSON).body(jObject.toString()).when().post("register");

        Assert.assertEquals(regResp.getStatusCode(), 201, "Unable to register");
        System.out.println("Register Response: "+regResp.getBody().asPrettyString());

        jObject.remove("confirmpassword");

        Response loginResp = given().log().all().contentType(ContentType.JSON).body(jObject.toString()).when().post("login");

        Assert.assertEquals(loginResp.getStatusCode(), 201, "Unable to login");

        token = loginResp.jsonPath().getString("data.token");
        Assert.assertNotNull(token, "Token is missing");

        userID = loginResp.jsonPath().getString("data.id");
        Assert.assertNotNull(userID, "UserID is missing");

        System.out.println("Login Response: "+loginResp.getBody().asPrettyString());
    }
}
