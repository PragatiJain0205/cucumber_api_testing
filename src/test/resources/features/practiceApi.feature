Feature:API Testing with REST Assured and Cucumber

  Scenario: API Test for GET Req
    Given the API endpoint "https://jsonplaceholder.typicode.com/posts/1"
    When I send a GET request
    Then the status code should be 200
    And the response should contain "title"
    And the response should contain "userId" with value 1

 Scenario: API test for POST Req
   Given the API endpoint "https://jsonplaceholder.typicode.com/posts/1"
   When I send a POST request with body:
    """
      {
        "title": "foo",
        "body": "bar",
        "userId": 1
      }
      """
   Then the status code should be 201
   And the response should contain "id"
