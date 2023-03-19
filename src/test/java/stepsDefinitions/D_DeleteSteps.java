package stepsDefinitions;

import java.sql.SQLException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D_DeleteSteps extends StepManager{

	
	@When("I delete new Category with name")
	public void i_delete_new_category_with_name() throws SQLException {
		dDatabaseconnect.deleteCategory();
	}

	@Then("the Category should be deleted from the database")
	public void the_category_should_be_deleted_from_the_database() throws SQLException {
		dDatabaseconnect.Validatedeletedata();
	}


}
