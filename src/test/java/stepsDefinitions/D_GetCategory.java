package stepsDefinitions;

import java.sql.SQLException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D_GetCategory extends StepManager{

	@When("Get request to display list of Category")
	public void getRequestToDisplayListOfCategory() throws SQLException {
	    
		dDatabaseconnect.getCategories();
	}

}
