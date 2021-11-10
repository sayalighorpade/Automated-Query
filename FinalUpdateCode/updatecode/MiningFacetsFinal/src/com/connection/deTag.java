package com.connection;

import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class deTag extends HTMLEditorKit.ParserCallback  {
	StringBuffer txt;
	  Reader reader;
	 public static String filename;
	  // empty default constructor
	  public deTag() {}

	  // more convienient constructor
	  public deTag(Reader r) {
	    setReader(r);
	  }

	  public void setReader(Reader r) { reader = r; }

	  public void parse() throws IOException {
	    txt = new StringBuffer();
	    ParserDelegator parserDelegator = new ParserDelegator();
	    parserDelegator.parse(reader, this, true);
	  }

	  public void handleText(char[] text, int pos) {
	    txt.append(text);
	  }

	  public String toString() {
	    return txt.toString();
	  }
	  
	  
	  public static String facest(String phrase,String url,int i)
	  {
		  deTag d = null ;
		  try {
     // the HTML to convert
     URL toRead;
     
                 {
                     filename="C:\\Users\\Learning\\Desktop\\Url\\"+phrase+ i+".txt";
            File file = new File(filename);
                     FileWriter fw = new FileWriter(file.getAbsoluteFile());
	BufferedWriter bw = new BufferedWriter(fw);
      // for ex: toRead = new URL("http://www.htmlgoodies.com/tutorials/getting_started/article.php/3863271/How-To-Build-a-Website-HTML-CSS-and-HTML-Editors.htm");
toRead = new URL(url);
     BufferedReader in = new BufferedReader(
       new InputStreamReader(toRead.openStream()));
  d  = new deTag(in);
     d.parse();
     in.close();
              bw.write(d.toString().replace("{","").replace("}","")+"\n");
                      bw.newLine();
                      bw.close();
       
                 }
              
   }
   catch (Exception e) {
     e.printStackTrace();
   }
		return d.toString();
		  
	  }
	  
	  public static void TFIDF(String filename)
	  {
		  BufferedReader br = null;
			FileReader fr = null;

			try {

				fr = new FileReader(filename);
				br = new BufferedReader(fr);

				String sCurrentLine;
				
				br = new BufferedReader(new FileReader(filename));
	
				while ((sCurrentLine = br.readLine()) != null) {
					//ArrayList<String> listdoc() = new ArrayList<String>();
						System.out.println("Line:"+sCurrentLine);	
					
				}

			} catch (IOException e) {

				e.printStackTrace();

			} finally {

				try {

					if (br != null)
						br.close();

					if (fr != null)
						fr.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
	  }
	  
	public static void main(String[] argv) {
	           ArrayList<String> url=new ArrayList<>();
                   url.add("http://www.mysmartprice.com/computer/pricelist/sony-laptop-price-list-in-india.html");
//                   url.add("http://www.mtu.edu/mechanical/engineering/");
//                   url.add("https://www.tripadvisor.in/LocationPhotoDirectLink-g190919-d1494332-i122594727-Baby_Elephant-Wigan_Greater_Manchester_England.html");
//                   url.add("http://www.htmlgoodies.com/tutorials/getting_started/article.php/3863271/How-To-Build-a-Website-HTML-CSS-and-HTML-Editors.htm");
//                   
                   try {
                
//                     if (!file.exists()) {
//				file.createNewFile();
//			}
// 
			
		      // the HTML to convert
		      URL toRead;
		      if(argv.length==1)
		        toRead = new URL(argv[0]);
		      else
                          for(int i=0;i<url.size();i++)
                          {
                              String filename="C:\\Users\\JP\\Desktop\\Url\\URlData'"+i+"'.txt";
                     File file = new File(filename);
                              FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
		       // toRead = new URL("http://www.htmlgoodies.com/tutorials/getting_started/article.php/3863271/How-To-Build-a-Website-HTML-CSS-and-HTML-Editors.htm");
toRead = new URL(url.get(i));
		      BufferedReader in = new BufferedReader(
		        new InputStreamReader(toRead.openStream()));
		      deTag d = new deTag(in);
		      d.parse();
		      in.close();
                       bw.write(d.toString().replace("{","").replace("}","")+"\n");
                               bw.newLine();
                               bw.close();
		      System.out.println(d.toString());
                          }
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
	}

}
