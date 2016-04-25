package edu.csula.datascience.acquisition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.*;
import javax.net.ssl.HttpsURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mongodb.DBCollection;


import edu.csula.datascience.model.Crime;
import edu.csula.datascience.model.CrimeJSON;
import twitter4j.Status;

public class APIDataCollector  {

	public static void main(String[] args) {
		
		 
	}

	
}
