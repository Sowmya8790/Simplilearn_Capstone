package API;

import java.util.Objects;

public class APIPageManager {

    private API_GetAllProducts aAPI_GetAllProducts;
    private API_GetCategory aAPI_GetCategory;
    


    public API_GetAllProducts aAPI_GetAllProducts()
    {
         return(Objects.isNull(aAPI_GetAllProducts))? aAPI_GetAllProducts= new API_GetAllProducts():aAPI_GetAllProducts;
    }
    
    
   
    public API_GetCategory aAPI_GetCategory()
    {
         return(Objects.isNull(aAPI_GetCategory))? aAPI_GetCategory= new API_GetCategory():aAPI_GetCategory;
    }

  
}
