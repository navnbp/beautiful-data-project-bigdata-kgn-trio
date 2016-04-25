package edu.csula.datascience.acquisition;


import java.util.Collection;
import java.util.stream.Collectors;
import org.bson.Document;
import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import edu.csula.datascience.model.Configuration;
import edu.csula.datascience.model.Crime;
import edu.csula.datascience.model.CrimeJSON;

public class APIDataCollector  implements Collector<Crime, CrimeJSON> {

	public static MongoClient mongoClient = null;
    MongoDatabase database;
    MongoCollection<Document> collection;
    DB db;
    
    @SuppressWarnings("deprecation")
	public DBCollection getCollection(String db, String tableName){
		return mongoClient.getDB(db).getCollection(tableName);
	}
    
	@Override
	public Collection<Crime> mungee(Collection<CrimeJSON> src) {
	return null;
	}

	@Override
	public void save(Collection<Crime> crimeLst) {
	
		if(crimeLst!=null && crimeLst.size()==0 )
			return;
	
	String mongoDbName=null,mongoCollection=null;
	DBCollection dbCollection=null;
	DBObject dbObject=null;
	 Gson  gson = new Gson();
	 
	try{
		mongoClient = new MongoClient("localhost", 27017);
		mongoDbName=Configuration.mongodatabase;
		mongoCollection=Configuration.mongocollection;
		dbCollection= this.getCollection(mongoDbName, mongoCollection) ;
		dbCollection.setWriteConcern(WriteConcern.UNACKNOWLEDGED);
	 
	}
	catch(Exception e){}
	
	
	 
	 for (Crime crime : crimeLst) 
	 {
		try{
		 dbObject = (DBObject) JSON.parse( gson.toJson(crime, Crime.class ));
		 dbCollection.insert(dbObject);
		 }catch(Exception e){}
	}
	 if(mongoClient!=null)
		 mongoClient.close();
		
		
		
		
	}

}
