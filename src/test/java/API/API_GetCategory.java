package API;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.GlobalConstants;
import extentManager.ExtentReport;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class API_GetCategory {
	

    String baseURI ="http://localhost:8090/medicare";    
    JsonPath json;	   
    
    
   
	public void LaunchURI(){
		RestAssured.baseURI = this.baseURI;
		ExtentReport.getTest().pass("Launch API URI");

				}	
	
		public Response GetCategoryProducts() {
			
			GlobalConstants.request = RestAssured.given();
			GlobalConstants.response = GlobalConstants.request.get("/json/data/category/1/products");
			System.out.println(GlobalConstants.response.getBody().asString());
			
			ExtentReport.getTest().pass("Launch Get request for category");
			return GlobalConstants.response ;
			
			
			
		}
		
	  public void catValidateStatusCode() {
				
			GlobalConstants.response = GetCategoryProducts();
	  	Assert.assertEquals(200, GlobalConstants.response.getStatusCode());
	  	
	  	ExtentReport.getTest().pass("Validate status code as 200");
	  }
	  
	  public void catValidateHeader() {
			
			ExtentReport.getTest().pass("Validated hearder in response");
			
			GlobalConstants.response = GetCategoryProducts();
			String header = GlobalConstants.response.getHeader("Content-Type").toString();
			String exphearder = "application/json;charset=UTF-8";
			Assert.assertEquals(header, exphearder);
		}
		
		
		public void catValidateCookies() {
			
			ExtentReport.getTest().pass("Validated cookies in response");
			
			GlobalConstants.response = GetCategoryProducts();
			String actcookie = GlobalConstants.response.getCookie("JSESSIONID").toString();
			System.out.println(actcookie);
		}
		
		
		
		
	  public void catJsondata() {
			
	  	
			GlobalConstants.response = GetCategoryProducts();
	  	json = GlobalConstants.response.jsonPath();
	  	List<Object> CatProduct = json.getList("name");
	  	
	  	
	  	System.out.println(CatProduct.size());
	  	
	  	//Api list to array
	  	for(int i=0;i<=CatProduct.size()-1;i++) {
	  		
	  		GlobalConstants.apicatProduct.add(CatProduct.get(i).toString());
	  	}
	  	
	  	System.out.println("API CatProducts :" + GlobalConstants.apicatProduct + "The size of Api cat products : "+ GlobalConstants.apicatProduct.size());
	  	System.out.println("UI Products :" + GlobalConstants.UIproduct + "The size of Api cat products : " + GlobalConstants.UIproduct.size());
	  }
		
		
		public void catValidateuiProducts()	{
			
			ExtentReport.getTest().pass("Validated UI Products and API catproducts in response");
			
			System.out.println(GlobalConstants.UIproduct + "The size of product in api :" + GlobalConstants.apicatProduct);
			
			for(int i=0;i<=GlobalConstants.apicatProduct.size()-1;i++) {
				
				for(int j=0;j<=GlobalConstants.UIproduct.size()-1;j++) {
					
					if(GlobalConstants.apicatProduct.get(i).equals(GlobalConstants.UIproduct.get(j))) {
						
						Assert.assertTrue(true);
					}
					
					else {
						Assert.assertFalse(true);
					}
					
				}
				
			}
		}
		
}
