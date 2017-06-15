package pages;
//package com.artOfTesting.mongo;
import com.mongodb.MongoClient;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
//import com.mongodb.DBObject;

//import org.testng.Assert;

public class MongoAutomation{
   public static void main( String args[] )
   {
	   DBCursor cursor =null; 
      try{   
    	  
	//Connecting to the mongoDB instance
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        
	//Selecting the database
        DB db = mongoClient.getDB("mydbtest");
        
       	
        //Selecting the collection
	DBCollection dbCollection = db.getCollection("mycollection");
	System.out.println("mycollection");
        
	//Setting search query with the required key-value pair
	BasicDBObject searchQuery = new BasicDBObject();
	//searchQuery.put("name", "testname1");
	 
	//DBCursor with the find query result
	 cursor = dbCollection.find(searchQuery);
   //  int i = 1;
	 String response = "";	
     while (cursor.hasNext()) { 
    //    System.out.println("Inserted Document: "+i); 
    	 response = response.concat((String) cursor.next().get("name"));
        System.out.println(response); 
      //  i++;
     }
		
  }catch(Exception e){
     System.err.println( e.getClass().getName() + ": " + e.getMessage() );
  }
  	finally { 
	   cursor.close();
	}
}
}

 
//        //Fetching the response
//	String response = null;			
//	try {
//	    while(cursor.hasNext()) {
//	    response = response.concat(cursor.next().toString());
//	   }
//	} 
//	finally { 
//	   cursor.close();
//	}
//		
//	//Asserting the fetched response with expected value
//	Assert.assertTrue(response.contains("ExpectedValue"));
//	}
//      catch(Exception e){
//	    System.out.println(e.getMessage());
//      }
//   }
//}