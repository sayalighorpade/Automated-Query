package com.searchinfo;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class TestGoogleSea1 {
	String[] p = new String[15];
	 String[] p1 = new String[15];
	 String[] p2 = new String[10];
	 public static ArrayList<String> URLans = new ArrayList<String>();
	 public static ArrayList<String> urlget =new ArrayList<String>();
	public static void main(String[] args) throws IOException {
		
			}
	
	public ArrayList<String> googleurls(String searchword)
	{
		String google = "http://www.google.com/search?q=";
		String search =searchword;
		String charset = "UTF-8";
		String userAgent = "ExampleBot 1.0 (+http://example.com/bot)"; // Change this to your company's name and bot homepage!

		int pp=0;
		Elements links;
		try {
			links = Jsoup.connect(google + URLEncoder.encode(search, charset)).userAgent(userAgent).get().select(".g>.r>a");
		

		for (Element link : links) {
		    String title = link.text();
		    String url = link.absUrl("href"); // Google returns URLs in format "http://www.google.com/url?q=<url>&sa=U&ei=<someKey>".
		    url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");

		    if (!url.startsWith("http")) {
		        continue; // Ads/news/etc.
		    }
		    
		    URLans.add(title+"#"+url);
		       p[pp]=url;
		       p1[pp]=title;
		       pp++;
//		      
		}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return URLans;
	}

}
