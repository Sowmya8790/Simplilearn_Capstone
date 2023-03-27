package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import constants.GlobalConstants;
import extentManager.ExtentReport;
import groovy.transform.builder.InitializerStrategy.SET;
import pages.LoginPage;

public class Databaseconnect {
	
	 private static Connection connection =null;
	    private static Statement statement = null;
	    private static PreparedStatement pstmt=null;
	
	  
	public static void a_initdataconnection() throws SQLException, ClassNotFoundException {
	    	Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost/medicare";  //&useSSL=false&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = "root";
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        
        ExtentReport.getTest().pass("Launch SQL Driver");
        
	    }
   
   
	    
	    public void b_insertCategory() throws SQLException {
	    	
	    	String insertreq = "INSERT INTO Category (name, description) VALUES (?,?);";
	    	
	    	pstmt = connection.prepareStatement(insertreq);
	    	pstmt.setString(1, GlobalConstants.dbcatname);
	    	pstmt.setString(2, GlobalConstants.dbdescription);
	    	//pstmt.setString(3, GlobalConstants.dbimage);
	    	//pstmt.setString(3, "true");
	    
	    	
	        pstmt.executeUpdate();
	    	System.out.println("Test Started insertcategory is : ");	    	
	    	ExtentReport.getTest().pass("Insert request for category");
	    	
	    }
	    
	   
	    public void getCategories() throws SQLException {
	    	
	    	String getreq = "Select name FROM Category;";
	    	
	    	System.out.println(getreq);
	    	ResultSet rs = statement.executeQuery(getreq); 
	    	System.out.println("Test Started getcategories is : ");
	    	
	    	
	    	while(rs.next()) {
	    			    		
	    		System.out.println("Get Category is : " +rs.getNString("name"));
	    	;	    			    		
	    	}
	    	ExtentReport.getTest().pass("Launch Get request for category");
	    	
	    }
	    
	   
	    public void ValidategetCategories() {
	    	
	    	for(int i=0;i<=GlobalConstants.dbcatProduct.size();i++) {
	    	
	    	if(GlobalConstants.dbcatProduct.get(i).equals(LoginPage.db_UIproduct.get(i))) {
	    		Assert.assertTrue(true);
	    	}
	    	else {
	    		
	    		Assert.assertFalse(true);
	    	}
	    	}
	    	
	    	ExtentReport.getTest().pass("validate Get request for category in GUI and database");
	    }
	    
	    
	    public void getCategory() throws SQLException {
	    	
	    	String getreq = "Select * FROM Category WHERE name = '" + GlobalConstants.dbcatname + "';";
	    	
	    	System.out.println(getreq);
	    	ResultSet rs = statement.executeQuery(getreq); 
	    	System.out.println("Test Started deletecategory is : ");
	    	
	    	while(rs.next()) {
	    		
	    		if(rs.getString("name").equals(GlobalConstants.dbcatname)) {
	    			
	    			Assert.assertTrue(true);
	    			break;
	    		}
	    	}
	    	ExtentReport.getTest().pass("Launch Get request for category");
	    	
	    }
	    
	    
	    
	   
	    public void deleteCategory() throws SQLException {
	    	
	    	String deletereq = "DELETE FROM Category WHERE name = '" + GlobalConstants.dbcatname + "';";
	    	
	    	System.out.println(deletereq);
	    	pstmt = connection.prepareStatement(deletereq);
	        int i=pstmt.executeUpdate();
	    	System.out.println("Test Started deletecategory");
	    	if(i==1) {
	    		System.out.println("Record deleted");
	    	}
	    	else {
	    		System.out.println("Record not deleted");
	    	}
	    	
	    	ExtentReport.getTest().pass("Launch Delete request for category");
	    	
	    }
	    
	        
	    public void Validatedeletedata() throws SQLException {
	    	
	    	String query = "Select * from Category;";  // where name ='" + GlobalConstants.dbcatname + "';";
	    	ResultSet rs = statement.executeQuery(query);
	    	
	    	while(rs.next()) {
	    		
	    		String act = rs.getString("name");
	    		String exp =  GlobalConstants.dbcatname;
	    		
	    		Assert.assertNotEquals(act, exp);
	    	}
	    	
	    	ExtentReport.getTest().pass("Category deleted from Database");
	    	
	    }
	    
	    
	    public void InsertUser() throws SQLException {
	    	
	    	String query = "INSERT INTO User_detail \r\n"
	    			+ "(first_name, last_name, role, enabled, password, email, contact_number) \r\n"
	    			+ "VALUES ('Sowmya', 'Varanasi', 'User', true, '$2a$10$2kvudlDcJC4qXOrVtMtU9.jvhCkOxwHbIZluYshykct9Ydv79h8Ni', 'vs@gmail.com', '9696969696');";
	    	
	    	pstmt = connection.prepareStatement(query);
	  
	    	
	    	pstmt.executeUpdate();
	    	
	    	System.out.println("Inserted User to database");
	    	ExtentReport.getTest().pass("Launch iNSERT request for NEW USER");
	    	
	    }
	    
	   
	    public void ValidateUser() throws SQLException {
	    	
	    	String query = " Select * from User_Detail where email='vs@gmail.com'";
	    	ResultSet rs= statement.executeQuery(query);
	    	
	    	rs.next();
	    	String actvalue = rs.getString("email");
	    	
	    	Assert.assertEquals(actvalue, "vs@gmail.com");
	    	
	    	ExtentReport.getTest().pass("Launch Get request to validate User added in database");
	    }

	    
	    
	 
	    public void e_freeConnection() {
	        if (connection == null) {
	            return;
	        }
	        try {	        	
	        	connection.close();
	        	statement.close();
	        } catch (SQLException e) {
	            System.out.println(e);
	        }
	        
	        ExtentReport.getTest().pass("Close Driver");
	    }
	    
	    

	
}
