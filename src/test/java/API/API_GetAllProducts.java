package API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import constants.GlobalConstants;
import extentManager.ExtentReport;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_GetAllProducts {
	
	

	
	    String baseURI ="http://localhost:8090/medicare";    
	    JsonPath json;	   
	    
	    @Test
		public void LaunchURI(){
	    	
			RestAssured.baseURI = this.baseURI;
			ExtentReport.getTest().pass("Launch API URI");

    }	
	   
			public Response GetAllProducts() {
				
				GlobalConstants.request = RestAssured.given();
				GlobalConstants.response = GlobalConstants.request.get("/json/data/all/products");
				System.out.println(GlobalConstants.response.getBody().asString());
				
				ExtentReport.getTest().pass("get request");
				return GlobalConstants.response ;
								
			}
	    
		  public void ValidateStatusCode() {
				
	    	ExtentReport.getTest().pass("Validate code is 200");
		  	
				GlobalConstants.response = GetAllProducts();
		  	Assert.assertEquals(200, GlobalConstants.response.getStatusCode());
		  }
			
			public void ValidateHeader() {
				
				ExtentReport.getTest().pass("Validated hearder in response");
				
				GlobalConstants.response = GetAllProducts();
				String header = GlobalConstants.response.getHeader("Content-Type").toString();
				String exphearder = "application/json;charset=UTF-8";
				Assert.assertEquals(header, exphearder);
			}
			
			
			public void ValidateCookies() {
				
				ExtentReport.getTest().pass("Validated cookies in response");
				
				GlobalConstants.response = GetAllProducts();
				String actcookie = GlobalConstants.response.getCookie("JSESSIONID").toString();
				System.out.println(actcookie);
			}
			
			
			
			
		  public void ZJsondata() {
				
		  	
				GlobalConstants.response = GetAllProducts();
		  	json = GlobalConstants.response.jsonPath();
		  	List<Object> Product = json.getList("name");
		  	
		  	
		  	System.out.println(Product.size());
		  	
		  	//Api list to array
		  	for(int i=0;i<=Product.size()-1;i++) {
		  		
		  		GlobalConstants.apiProduct.add(Product.get(i).toString());
		  	}
		  	
		  	System.out.println("API Products :" + GlobalConstants.apiProduct);
		  	System.out.println("UI Products :" + GlobalConstants.UIproduct);
		  }
			
			
			public void ValidateuiProducts() {
				
				ExtentReport.getTest().pass("Validated UI Products and API products in response");
				
				System.out.println(GlobalConstants.UIproduct + "The size of product in api :" + GlobalConstants.apiProduct);
				
				for(int i=0;i<=GlobalConstants.apiProduct.size()-1;i++) {
					
					for(int j=0;j<=GlobalConstants.UIproduct.size()-1;j++) {
						
						if(GlobalConstants.apiProduct.get(i).equals(GlobalConstants.UIproduct.get(j))) {
							
							Assert.assertTrue(true);
						}
						
						else {
							Assert.assertFalse(true);
						}
						
					}
					
				}
			}
			
			
			
			

}
