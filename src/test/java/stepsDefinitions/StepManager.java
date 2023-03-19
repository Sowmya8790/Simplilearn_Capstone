package stepsDefinitions;


import API.APIPageManager;
import API.API_GetAllProducts;
import API.API_GetCategory;
import JDBCConnection.DataPageManager;
import JDBCConnection.Databaseconnect;
import pages.*;

public class StepManager {

        PageManager pageManager;
        LoginPage loginPage;
        ProductPage productPage;
        ShippingPage shippingPage;
        PaymentPage paymentPage;
        ManageProductPage manageProductPage;
        RegisterPage registerPage;
        API_GetAllProducts aAPI_GetAllProducts;
        APIPageManager apiPageManager;
        API_GetCategory aAPI_GetCategory;
        Databaseconnect databaseconnect;
        DataPageManager datamanager;
        Databaseconnect dDatabaseconnect;
      

    public StepManager()
    {
        initializePages();
    }

    public void initializePages(){

        pageManager=new PageManager();
        apiPageManager = new APIPageManager();
        datamanager = new DataPageManager();
        registerPage = pageManager.getRegisterPage();
        loginPage=pageManager.getLoginPage();
        productPage = pageManager.getproductPage();
        shippingPage = pageManager.getShippingPage();
        paymentPage = pageManager.getPaymentPage();
        manageProductPage = pageManager.getManageProductPage();
        aAPI_GetAllProducts = apiPageManager.aAPI_GetAllProducts();
        aAPI_GetCategory = apiPageManager.aAPI_GetCategory();
        dDatabaseconnect = datamanager.d_getDatabaseconnect();
    }
}
