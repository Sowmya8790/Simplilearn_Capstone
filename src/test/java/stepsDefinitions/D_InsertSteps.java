package stepsDefinitions;

import java.sql.SQLException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D_InsertSteps extends StepManager{
	

@Given("I have a database connection")
public void i_have_a_database_connection() throws ClassNotFoundException, SQLException {
	dDatabaseconnect.a_initdataconnection();
}

@When("I insert a new Category with name and description")
public void i_insert_a_new_category_with_name_and_description() throws SQLException {
	dDatabaseconnect.b_insertCategory();
}

@Then("the Category should be added to the database")
public void the_category_should_be_added_to_the_database() throws SQLException {
	dDatabaseconnect.getCategory();
}

@Then("check Category Displaying in GUI")
public void check_category_displaying_in_GUI() {
	manageProductPage.Validatecatgoryaddedornotindatabase();
}

@Then("Close the driver")
public void close_the_driver() {
    
	dDatabaseconnect.e_freeConnection();
}


}
