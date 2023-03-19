Feature: Inserting data into the database

  Scenario: Inserting a new Category
    Given I have a database connection
    When I insert a new Category with name and description
    Then the Category should be added to the database
    Then check Category Displaying in GUI
    And Close the driver

  Scenario: Delete a new Category
    Given I have a database connection
    When I delete new Category with name
    Then the Category should be deleted from the database
    And Close the driver

  Scenario: Add a new User
    Given I have a database connection
    When I Add new User with required details
    Then the User should be added to the database
    And Close the driver
    When User launch the URL.
    And Click on login
    And Validate lated on Loginpage of medicare
    And Enter the user "vs@gmail.com" and password "12345"
    And click on login button
    Then Validate Admin/User logged into the application
