package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class API_viewallProductsSteps extends StepManager{
	
	@Given("the API endpoint is {string}")
	public void theAPIEndpointIs(String string) {
	    
		aAPI_GetAllProducts.LaunchURI();
	}

	@When("a GET request is sent")
	public void aGETRequestIsSent() {
		aAPI_GetAllProducts.GetAllProducts();
	}

	@Then("the response status code should be {int}")
	public void theResponseStatusCodeShouldBe(Integer int1) {
		aAPI_GetAllProducts.ValidateStatusCode();
	}

	@And("Validate cookies and hearder")
	public void validateCookiesAndHearder() {
		aAPI_GetAllProducts.ValidateCookies();
		aAPI_GetAllProducts.ValidateHeader();
	}

	@And("the response should contain a list of Products")
	public void theResponseShouldContainAListOfProducts() {
		aAPI_GetAllProducts.ZJsondata();
	}
	
	@And("Validate the products in UI and API")
	public void validateTheProductsInUIAndAPI() {
		aAPI_GetAllProducts.ValidateuiProducts();
	}

}
