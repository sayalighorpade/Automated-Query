package com.searchinfo;

import java.util.HashMap;
import java.util.Map;



public class VCS {
	Map<String, Integer> wordMap = new HashMap<String, Integer>();

    public void incCount(String word) {
        Integer oldCount = wordMap.get(word);
        wordMap.put(word, oldCount == null ? 1 : oldCount + 1);
    }

    double getCosineSimilarityWith(VCS otherVector) {
        double innerProduct = 0;
        double vcs = 0;
        String str;
        for(String w: this.wordMap.keySet()) {
            innerProduct += this.getCount(w) * otherVector.getCount(w);
        }
        str=String.valueOf(innerProduct / (this.getNorm() * otherVector.getNorm()));
        if(str.equals("NaN"))
        {
        	vcs=0.0;
        }
        else
        {  vcs= innerProduct / (this.getNorm() * otherVector.getNorm());
   
        }
		return vcs;
        }

    double getNorm() {
        double sum = 0;
        for (Integer count : wordMap.values()) {
            sum += count * count;
        }
        return Math.sqrt(sum);
    }

    int getCount(String word) {
        return wordMap.containsKey(word) ? wordMap.get(word) : 0;
    }

    public double GetSimilarity(String vector1, String vector2) {
        String doc1 = vector1;
        String doc2 = vector2;

        VCS v1 = new VCS();
        for(String w:doc1.split("[^a-zA-Z]+")) {
            v1.incCount(w);
        }

        VCS v2 = new VCS();
        for(String w:doc2.split("[^a-zA-Z]+")) {
            v2.incCount(w);
        }

       // System.out.println("Similarity = " + v1.getCosineSimilarityWith(v2));
        return v1.getCosineSimilarityWith(v2);
    }
public static void main(String args[])
{
           VCS cs=new VCS();
          double total= cs.GetSimilarity("Organic Tulsi Tea ", "Tulsi");
           System.out.println(total);
           
}

}
