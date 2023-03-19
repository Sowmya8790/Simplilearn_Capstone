package API;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.GlobalConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getSingleProduct {
	
	 String baseURI ="http://localhost:8090/medicare";    
	  
	@Test
public Response GetSingleEmp(){
				RestAssured.baseURI = this.baseURI;
				GlobalConstants.request = RestAssured.given();
				GlobalConstants.response = GlobalConstants.request.get("/json/data/category/1/products");
				System.out.println("The response is :" + GlobalConstants.response.getBody().asString());
				return GlobalConstants.response ;				
			}	

	@Test
  public void ValidateStatusCode(String responsee) {
  	
		GlobalConstants.response = GetSingleEmp();
  //	Assert.assertEquals(200, GlobalConstants.response.getStatusCode());
  }
	
	@Test
	public void ValidateHeader() {
		
		GlobalConstants.response = GetSingleEmp();
		String header = GlobalConstants.response.getHeader("Content-Type").toString();
		String exphearder = "application/json;charset=UTF-8";
		Assert.assertEquals(header, exphearder);
	}
	
	@Test
	public void ValidateCookies() {
		
		GlobalConstants.response = GetSingleEmp();
		String actcookie = GlobalConstants.response.getCookie("JSESSIONID").toString();
		System.out.println(actcookie);
	}
	
	

}
