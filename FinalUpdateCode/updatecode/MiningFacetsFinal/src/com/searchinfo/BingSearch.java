package com.searchinfo;
import java.io.IOException;  
import java.util.ArrayList;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;  

public class BingSearch {
	 public static ArrayList<String> bingarray =new ArrayList<String>();
	public static final String BING_SEARCH_URL = "https://www.bing.com/search";
	static int num=8;
	public static ArrayList<String> bingurls(String searchword)
	{
		String word=searchword.toString().trim();
		
		String searchURL = BING_SEARCH_URL + "?q=" + word ;//+ "&count=" + num;
	   	     Document doc;
			try {
				doc = Jsoup.connect(searchURL).get();
				 Elements result = doc.select("li.b_algo h2 a");
		   	     for (Element res : result) {
		   	    	
		   	    	String linkHref = res.attr("href");
		   	    	//if(linkHref.indexOf("https:")==-1)
		   	    	{
		   	    	System.out.println("BingUrl="+ linkHref);
		   	      String title = res.text();
		   	   TestGoogleSea1.URLans.add(title+"#"+linkHref);
		   	    	}
		   	    	
		   	    	
		   	     }
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   	    // Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0,Chrome/39.0.2171.71").get();
	    	    
	   	    
		return bingarray;
		
		
		
		
	}
	
	
	
	
	
	
	
    public static void main( String[] args ) throws IOException{ 
   	//int num=8;
   	String word="sony";
   	bingurls(word.toString().replace(" ","+"));
//   	String description = null;
//   	 String searchURL = BING_SEARCH_URL + "?q=" + word;
//   	 // + "&count=" + num;
//   	     Document doc = Jsoup.connect(searchURL).get();
//   	    // Document doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0,Chrome/39.0.2171.71").get();
//    	    
//   	     Elements result = doc.select("li.b_algo h2 a");
//   	     for (Element res : result) {
//   	    	String linkHref = res.attr("href");
//   	    	//if(linkHref.indexOf("https:")==-1)
//   		 {
//   	         
//   	      String title = res.text();
//   	   Document desc = Jsoup.connect(linkHref).get();
//   	   description = desc.select("meta[name=description]").get(0)
//				.attr("content");
//   	         System.out.println("href="+ linkHref);
//   	      System.out.println("title="+ title);
//   	   System.out.println("description="+ description);
//   	     }
//   	     }
   	 

}  
}
