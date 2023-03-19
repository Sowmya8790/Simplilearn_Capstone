package stepsDefinitions;

import java.sql.SQLException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D_InsertUser extends StepManager{

	

	@When("I Add new User with required details")
	public void i_add_new_user_with_required_details() throws SQLException {
	    
		dDatabaseconnect.InsertUser();
	}

	@Then("the User should be added to the database")
	public void the_user_should_be_added_to_the_database() throws SQLException {
	   
		dDatabaseconnect.ValidateUser();
	}

}
