package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PracticeApiSteps {
    private String apiUrl;
    private Response response;

    @Given("the API endpoint {string}")
    public void api_end_point(String url){
        this.apiUrl = url;
    }
    @When(" I send a GET request")
    public void get_req(){
        response =given()
                .when().get(apiUrl);

    }
    @When(" I send a POST request with body:")
    public void post_req(String requestBody){
        response=given()
                .body(requestBody)
                .when().post(apiUrl);
    }
    @Then("the status code should be {int}")
    public void status_code(int code){
        response.then().statusCode(code);
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String key) {
        response.then().body(key, notNullValue());
    }
    @Then("the response should contain {string} with value {int}")
    public void the_response_should_contain_with_value(String key, int value) {
        response.then().body(key, equalTo(value));
    }


}
