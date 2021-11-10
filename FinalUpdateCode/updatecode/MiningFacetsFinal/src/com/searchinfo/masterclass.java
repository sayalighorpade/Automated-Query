package com.searchinfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


import com.connection.Dbconn;
import com.connection.deTag;

public class masterclass {
	public static int id = 0,fileid=0;
	public static String word;
	public static ArrayList<String> docurl = new ArrayList<String>();
	static ArrayList<Double> tfidflist = new ArrayList<Double>();
	static ArrayList<Double> cslist = new ArrayList<Double>();
	 double fIdf,tfIdf,qt=0.25,qt1=0.50,qt2=0.75;
	public static double c1,c2,c3,c4;
public static double css =0,total = 0;
	private static DecimalFormat df2 = new DecimalFormat("#.##");
	String rank;
	static List<String> doc1;
	static List<String> doc2;
	static List<String> doc3;
	static List<String> doc4;
	static List<String> doc5;
	static List<String> doc6;

	public void master(String phrase) {
       		
		tfidflist.clear();
		cslist.clear();
		word = phrase;
		VCS vcs = new VCS();
		try {

			Connection con = Dbconn.conn();
			  c1=1;
			  c2=1;
			  c3=1;
			  c4=1;
			Statement stIsExist = con.createStatement();
			ResultSet rsIsExist = stIsExist
					.executeQuery("select * from trainningdata where searchphrase='"
							+ phrase + "'");

			if (rsIsExist.next()) {
				System.out.println("----Exist in db-----");

			} else {

				ArrayList<String> URLans = new ArrayList<String>();
				TestGoogleSea1 googleurls = new TestGoogleSea1();
				URLans = googleurls.googleurls(phrase);
				Statement st1 = (Statement) con.createStatement();
				Statement st11 = (Statement) con.createStatement();

				masterclass m = new masterclass();

				for (int k = 0; k < URLans.size(); k++) {
					// get the URLs
					String[] data = URLans.get(k).toString().split("#");
					//
					// get the features
					String Title = m.GetTitle(data[1]);
					
					String desc = m.GetDescription(data[1]);
					
					// deTag de = new deTag();
long strating=System.currentTimeMillis();
if (Title != null && desc != null) {
						System.out.println(fileid + "th TITLE is \t" + Title);
						System.out.println(fileid + "th desc is \t" + desc);
						ResultSet rs = st1
								.executeQuery("select count(*) from trainningdata");

						if (rs.next()) {
							id = rs.getInt(1) + 1;
						}

						String url = data[1].replaceAll("'", "");
						String str = deTag.facest(phrase, url,fileid);// Extracting
																	// url data
																	// text file
																	// write
						for (int i = 0; i <= 6; i++) {
							addlist(str, i);// call function add list in file
											// extracting data
						}
//						TFIDFCalculator calculator = new TFIDFCalculator();
//						List<List<String>> documents = Arrays.asList(doc1,
//								doc2, doc3, doc4, doc5, doc6);
						//tfIdf = calculator.tfIdf(doc1, documents, word);
						long endingtimetf=System.currentTimeMillis();
						long totaltf=endingtimetf-strating;
						System.out.println("Time:"+totaltf+"TfIdf:=" + tfIdf);
						if(tfIdf<=qt)
		        		   {
							rank=df2.format(tfIdf/c1);
						st11.executeUpdate("insert into facetmaster values('"+phrase+"','"
								+ url + "','" + rank + "')");
//						tfidflist.add(tfIdf);
							System.out.println("Rank:=" + rank);
							c1++;
		        		   }
						else if(tfIdf<=qt1)
						{
							
							rank=df2.format(tfIdf/c2);
							System.out.println("Rank:=" + rank);
							st11.executeUpdate("insert into facetmaster values('"+phrase+"','"
									+ url + "','" + rank + "')");
							c2++;
						}
						else if(tfIdf<=qt2)
						{
							rank=df2.format(tfIdf/c3);
							System.out.println("Rank:=" + rank);
							st11.executeUpdate("insert into facetmaster values('"+phrase+"','"
									+ url + "','" + rank + "')");
							c3++;
						}
						else
						{
							rank=df2.format(tfIdf/c4);
							System.out.println("Rank:=" + rank);
							st11.executeUpdate("insert into facetmaster values('"+phrase+"','"
									+ url + "','" + rank + "')");
							c4++;
						}
						long stratingtimevcs=System.currentTimeMillis();
						String[] datastr = str.split("\\,");
						if (datastr.length >= 3) {
							for (int j = 0; j < datastr.length; j++) {
								

								css = vcs.GetSimilarity(datastr[j]
										.toString().toLowerCase(), phrase
										.toLowerCase());
								if (css > 0.0) {
									cslist.add(css);
									total=css+total;
									System.out.println("Vcs Total:=" + css);
								}

							}//for loop end
							long endingtimevcs=System.currentTimeMillis();
							long totaltimevcs=endingtimevcs-stratingtimevcs;
							System.out.println("Time:"+totaltimevcs+"\tVcs Total:=" + total);
						}

						// Append data into URL set
						st1.executeUpdate("insert into trainningdata values('"
								+ id + "','" + phrase + "','"
								+ data[1].replaceAll("'", "") + "','"
								+ Title.replaceAll("'", "") + "','"
								+ desc.replaceAll("'", "") + "')"); // url
																	// title
																	// keyworsd
																	// and
																	// description
						System.out.println("Done");
						//
						System.out
								.println("Insert data------------------------");
						fileid++;
					}
					

				}

			}

		} catch (Exception e) {
			System.err.println("master function");
			e.printStackTrace();
		}

	}

	public static void addlist(String str, int i) {
		if (i == 1) {
			doc1 = Arrays.asList(str);
		}
		if (i == 2) {
			doc2 = Arrays.asList(str);
		}
		if (i == 3) {
			doc3 = Arrays.asList(str);
		}
		if (i == 4) {
			doc4 = Arrays.asList(str);
		}
		if (i == 5) {
			doc5 = Arrays.asList(str);
		}
		if (i == 6) {
			doc6 = Arrays.asList(str);
		}

		//

	}

	public static void main(String args[]) {

	}

	// ////////Extracting keywords
	// public String Getkeyword(String URL) {
	// String keywords = null;
	// try {
	// Document doc = Jsoup.connect(URL).get();
	// keywords = doc.select("meta[name=keywords]").first()
	// .attr("content");
	// // System.out.println("Meta keyword : " + keywords);
	// } catch (Exception e) {
	// System.err.println("Get Keyword Function");
	// // e.printStackTrace();
	// }
	// return keywords;
	// }

	// //////Extracting description

	public String GetDescription(String URL) {
		String description = null;
		try {
			Document doc = Jsoup.connect(URL).get();
			description = doc.select("meta[name=description]").get(0)
					.attr("content");
			// System.out.println("Meta description : " + description);
		} catch (Exception e) {
			// System.err.println("Get Discriptionfunction");
			// e.printStackTrace();
		}
		return description;
	}

	// //////Extracting title
	public String GetTitle(String URL) {
		String title = null;
		try {
			Document doc = Jsoup.connect(URL).get();
			title = doc.title();
			// System.out.println("title is: " + title);
		} catch (Exception e) {
			// System.err.println("Get title function");
			// e.printStackTrace();
		}
		return title;
	}

	// //////Extracting anchor tags

}
