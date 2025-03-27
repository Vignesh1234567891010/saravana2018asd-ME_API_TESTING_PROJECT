package qtripTest.APITesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.UUID;

public class testCase_API_03 extends BaseTest{

    private static String email;
    private static String password;
    private static String token;
    private static String UserID;
    private static String adventureID;
    private static String bookingID;
    private JSONObject jObject;
    private JSONObject bookingRequest;

    @Test(priority = 3, enabled = true, groups = "API Tests")
    public void bookReservation_getReservation(){

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
    }
}
