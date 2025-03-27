package qtripTest.APITesting;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.io.File;

public class testCase_API_02 extends BaseTest {

    private JSONArray jArray;
    private JSONObject cityData;
    private static String schemaFilePath = new File("src/test/resources/schema.json").getAbsolutePath();

    @Test(priority = 2, enabled = true, groups = "API Tests")
    public void getCities(){

        Response resp = given().log().all().queryParam("q", "beng").when().get("cities");

        Assert.assertEquals(resp.getStatusCode(), 200, "Status Code Does not Match");

        jArray = new JSONArray(resp.getBody().asString());

        Assert.assertEquals(jArray.length(), 1, "More than one city  Found");

        cityData = jArray.getJSONObject(0);

        Assert.assertTrue(cityData.getString("description").contains("100+ Places"), "Description Does Not Match");

        resp.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(schemaFilePath)));

        System.out.println("Search API Response: " + resp.getBody().asPrettyString());
    }
}
