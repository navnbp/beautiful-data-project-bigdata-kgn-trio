package edu.csula.datascience.acquisition;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import com.fasterxml.jackson.databind.ObjectMapper;


import edu.csula.datascience.model.Crime;
import edu.csula.datascience.model.CrimeJSON;

public class APIDataCollectorApp  {

	public static void main(String[] args) {
		
		APIDataSource apiDataSource=new APIDataSource();
//		apiDataSource.getDataFromAPI();
		 
		  	System.exit(0);
	}

	

}
