package stepdefinitions.apisteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ApiVerifyCompanyName {
    private Response response;
    private RequestSpecification request;

    @Given("User has API endpoint {string} execute")
    public void user_has_api_endpoint(String endpoint) {
        RestAssured.baseURI = endpoint;
        request = RestAssured.given().header("X-Requested-With", "XMLHttpRequest");
    }
    @When("User sends a GET request with the following details execute:")
    public void user_sends_a_get_request_with_the_following_details(DataTable dataTable) {
        // Convert the DataTable to a List of Maps
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);


        // Iterate through the List of Maps and add form parameters
        for (Map<String, String> row : data) {
            request.formParam("email",row.get("email")).formParam("password",row.get("password"));
        }

        response = request.get();
    }
    @Then("The API should respond with status code {int} execute")
    public void the_api_should_respond_with_status_code(Integer expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertTrue(actualStatusCode==expectedStatusCode);
    }

    @Then("The response {string} should be {string} execute")
    public void the_response_should_be(String path, String expected) {
        String actual =response.jsonPath().getString(path);
        Assert.assertEquals(expected,actual);
    }
}
