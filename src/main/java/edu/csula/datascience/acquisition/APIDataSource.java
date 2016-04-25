package edu.csula.datascience.acquisition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.csula.datascience.model.Configuration;
import edu.csula.datascience.model.Crime;
import edu.csula.datascience.model.CrimeJSON;


public class APIDataSource implements Source<CrimeJSON> {

	private String input = null;
	 private long ct=0;
	 int exceptionct=0;
	 private BufferedReader br=null; 
	  private ObjectMapper mapper=new ObjectMapper();
	  List<CrimeJSON> listJson=new ArrayList<CrimeJSON>();
	  
	  public APIDataSource(){}
	  
	@Override
	public boolean hasNext() {
		return true;
	}

	@Override
	public Collection<CrimeJSON> next()  {
		
		try{
			  
			  if(input.substring(0,1).contains("["))
				  input = input.substring(1);
		    
		    else if(input.substring(0,1).contains(","))
			     input = input.substring(1);
			  
			    listJson.add(mapper.readValue(input, CrimeJSON.class));
			  	ct++;
			   
		    }catch(Exception e)
		    {
		    	System.out.println("1-->"+e.getMessage());
		    	e.printStackTrace();
		    	  exceptionct++;
		    }
		 
		 return listJson;
	}
	
}
