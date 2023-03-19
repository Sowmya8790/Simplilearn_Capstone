package JDBCConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Objects;

import org.testng.annotations.Test;

import API.API_GetCategory;

public class DataPageManager {
	
	private Databaseconnect databaseconnect;

    public Databaseconnect d_getDatabaseconnect()
    {
         return(Objects.isNull(databaseconnect))? databaseconnect= new Databaseconnect():databaseconnect;
    }

	
	
}
