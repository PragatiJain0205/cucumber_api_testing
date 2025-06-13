package stepDefinitions;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiSteps {

    private String apiUrl;
    private Response response;

    @Given("the API endpoint {string}")
    public void the_api_endpoint(String url) {
        this.apiUrl = url;
    }

    @When("I send a GET request")
    public void i_send_a_get_request() {
        response = given()
                .when()
                .get(apiUrl);
    }

    @When("I send a POST request with body:")
    public void i_send_a_post_request_with_body(String requestBody) {
        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(apiUrl);
    }

    @Then("the status code should be {int}")
    public void the_status_code_should_be(int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }

    @Then("the response should contain {string} with value {int}")
    public void the_response_should_contain_with_value(String key, int value) {
        response.then().body(key, equalTo(value));
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String key) {
        response.then().body(key, notNullValue());
    }
}
