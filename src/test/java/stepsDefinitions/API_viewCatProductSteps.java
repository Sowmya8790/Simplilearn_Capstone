package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class API_viewCatProductSteps extends StepManager{
	
	@When("a GET request is sent to fect Category Products")
	public void a_get_request_is_sent_to_fect_category_products() {
	    
		aAPI_GetCategory.GetCategoryProducts();
	}

	@Then("the response status code of Category should be {int}")
	public void the_response_status_code_of_category_should_be(Integer int1) {
	   
		aAPI_GetCategory.catValidateStatusCode();
	}

	@And("Validate category cookies and hearder")
	public void validate_category_cookies_and_hearder() {
	   
		aAPI_GetCategory.catValidateCookies();
		aAPI_GetCategory.catValidateHeader();
	}

	@And("the response should contain a list of Products in category")
	public void the_response_should_contain_a_list_of_Products_in_category() {
		aAPI_GetCategory.catJsondata();
		
		
	}

	@And("Validate the Category products in UI and API")
	public void validate_the_category_products_in_ui_and_api() {
	    
		aAPI_GetCategory.catValidateuiProducts();
	}


}
