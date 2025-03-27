package qtripTest.APITesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.UUID;

public class testCase_API_04 extends BaseTest {

    private static String email;
    private static String password;
    private static JSONObject jObject;

    @Test(priority = 4, enabled = true, groups = "API Tests")
    public void verifyDuplicateRegister(){

        jObject = new JSONObject();

        email = "vicky"+ UUID.randomUUID().toString()+"gmail.com";
        password = "password12";

        jObject.put("email", email);
        jObject.put("password", password);
        jObject.put("confirmpassword", password);

        Response firstResp = given().log().all().contentType(ContentType.JSON).body(jObject.toString()).when().post("register");

        Assert.assertEquals(firstResp.getStatusCode(), 201, "Unable to Register with new Email");

        System.out.println("First Response: "+firstResp.getBody().asPrettyString());

        Response secondResp = given().log().all().contentType(ContentType.JSON).body(jObject.toString()).when().post("register");

        Assert.assertEquals(secondResp.getStatusCode(), 400, "Registered with Existing Email");

        String errorMessage = secondResp.jsonPath().getString("message");

        Assert.assertEquals(errorMessage, "Email already exists", "Incorrect error message");

        System.out.println("Second Response: "+secondResp.getBody().asPrettyString());
    }
}
