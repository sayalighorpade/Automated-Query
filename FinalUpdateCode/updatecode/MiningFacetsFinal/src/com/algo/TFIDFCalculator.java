package com.algo;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Mohamed Guendouz
 */
public class TFIDFCalculator {
    /**
     * @param doc  list of strings
     * @param term String represents a term
     * @return term frequency of term in document
     */
	static double tf, tfIdf,finaltfidf=0.0;
	public static DecimalFormat df2 = new DecimalFormat("#.##");
	public double tfnew(ArrayList<String> docs, String term) {
		double result = 0,rr=0;
        rr=docs.size();
        
		for (int i = 0; i < docs.size(); i++) {
			if(docs.get(i).toLowerCase().indexOf(term.toLowerCase())!=-1)
 	    	{
 	    		result++;
	 	    	}
 	    else
 	    {
 	    	
 	    }
 	    	
 	    }
		return result/rr;
		
	}
	
	
	
	 public double tf(ArrayList<String> docs, String term) {
	        double result = 0,rr=0;
	        rr=docs.size();
	         for(int i=0;i<docs.size();i++)
	        {
	        	String data=docs.get(i).toString();
	        	 Pattern p=Pattern.compile(term.toLowerCase());
	 	    	Matcher m=p.matcher(data.toLowerCase());
	 	    	while(m.find())
	 	    	{
	 	    		result++;
	 	    		
	 	    	}
	 	    	
	 	    	
	        }
	       
	        return result/rr;
	    }
    /**
     * @param docs list of list of strings represents the dataset
     * @param term String represents a term
     * @return the inverse term frequency of term in documents
     */
    
    public double idf(ArrayList<ArrayList<String>> docs, String term) {
        double n = 1;
         for(int i=0;i<docs.size();i++)
        {
        	String data=docs.get(i).toString();
        	 Pattern p=Pattern.compile(term.toLowerCase());
 	    	Matcher m=p.matcher(data.toLowerCase());
 	    	while(m.find())
 	    	{
 	    		n++;
 	    		
 	    		
 	    	}
 	    	
        }
        
        return docs.size() / n;
    }
    
    
    /**
     * @param doc  a text document
     * @param docs all documents
     * @param term term
     * @return the TF-IDF of term
     */
public double tfIdf(double doc, ArrayList<ArrayList<String>> docs, String term) {
    	
        double tfidf=doc * idf(docs, term);
        finaltfidf=tfidf+finaltfidf;
    	System.out.println("Result TF="+df2.format(doc)+"\tResult Idf = " +df2.format(idf(docs, term))+"\tFinal Result TfIdf="+df2.format(finaltfidf));
        return doc * idf(docs, term);

    }

    public static void main(String[] args) {



    }


}