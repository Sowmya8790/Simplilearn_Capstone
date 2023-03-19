Feature: Get Products API

  Scenario: Retrieving a list of Products
    Given the API endpoint is "http://localhost:8080/medicare"
    When a GET request is sent
    Then the response status code should be 200
    And Validate cookies and hearder
    And the response should contain a list of Products
    And Validate the products in UI and API 



  Scenario: Delete a single category Products
    Given the API endpoint is "http://localhost:8080/medicare"
    When a GET request is sent to fect Category Products
    Then the response status code of Category should be 200
    And Validate category cookies and hearder
    And the response should contain a list of Products in category
    And Validate the Category products in UI and API
    
    
    