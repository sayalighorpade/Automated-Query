package com.searchinfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.algo.TFIDFCalculator;
import com.connection.Dbconn;
import com.connection.deTag;

public class newmasterclass {
	public static int id = 0, fileid = 0;
	public static String word;
	static ArrayList<Double> toplist = new ArrayList<Double>();
	static ArrayList<Integer> topindex = new ArrayList<Integer>();
	public static ArrayList<String> docdata = new ArrayList<String>();
	public static ArrayList<String> datalist = new ArrayList<String>();
	public static ArrayList<String> finaldata = new ArrayList<String>();
	public static ArrayList<String> dataurl = new ArrayList<String>();
	
	static ArrayList<Double> topvcs = new ArrayList<Double>();
	static ArrayList<String> cslist = new ArrayList<String>();
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static double tf, tfIdf,finaltfidf;
	static ArrayList<Double> tflist = new ArrayList<Double>();
	static ArrayList<ArrayList<String>> documents = new ArrayList<ArrayList<String>>();
	static ArrayList<ArrayList<String>> finaldocument = new ArrayList<ArrayList<String>>();
	public static String no = "0";
	public static double css = 0, total = 0, vcscount = 0, finalvcs = 0;
	public static double vcs1, vcs2, vcs3, vcs4, vcs5, vcs6;
//	public static double vcs7, vcs8, vcs9, vcs10;
	public static DecimalFormat df2 = new DecimalFormat("#.##");
	public static String finallist = null;
	public static String[] datacomma;
	static ArrayList<String> doc1 = new ArrayList<String>();
	static ArrayList<String> doc2 = new ArrayList<String>();
	static ArrayList<String> doc3 = new ArrayList<String>();
	static ArrayList<String> doc4 = new ArrayList<String>();
	static ArrayList<String> doc5 = new ArrayList<String>();
	static ArrayList<String> doc6 = new ArrayList<String>();
	
//	static ArrayList<String> doc7 = new ArrayList<String>();
//	static ArrayList<String> doc8 = new ArrayList<String>();
//	static ArrayList<String> doc9 = new ArrayList<String>();
//	static ArrayList<String> doc10 = new ArrayList<String>();
	
	static long strating;
	static long endingtime = 0;
	static long totalvcs = 0;
	static long endingtimetf = 0;
	static long totaltf = 0;
	public static String[] datastr;

	public static String master(String phrase,String Username) {
		String finalname = "";
		Date date = Calendar.getInstance().getTime();

		// Display a date in day, month, year format
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String today = formatter.format(date);
		System.out.println("Today1 : " + today);

		newmasterclass.doc1.clear();
		newmasterclass.doc2.clear();
		newmasterclass.doc3.clear();
		newmasterclass.doc4.clear();
		newmasterclass.doc5.clear();
		newmasterclass.doc6.clear();
//		newmasterclass.doc7.clear();
//		newmasterclass.doc8.clear();
//		newmasterclass.doc9.clear();
//		newmasterclass.doc10.clear();
		
		cslist.clear();
		
		word = phrase;
		int k = 0;
		VCS vcs = new VCS();
		try {

			Connection con = Dbconn.conn();
			Statement stIsExist = con.createStatement();
			 Statement st13 = (Statement) con.createStatement();
	            
	            Statement st12 = (Statement) con.createStatement();
	           
			ResultSet rsIsExist = stIsExist
					.executeQuery("select * from trainningdata where searchphrase='"
							+ phrase + "'");

			if (rsIsExist.next()) {
				System.out.println("----Exist in db-----");
				no = "0";

			} else {
				
				no = "1";
				 st13.executeUpdate("truncate countmaster");
		            st12.executeUpdate("truncate countcluster");
				
				TestGoogleSea1 googleurls = new TestGoogleSea1();
			 googleurls.googleurls(phrase);
			 BingSearch.bingurls(phrase.replace(" ","+").trim());
				Statement st1 = (Statement) con.createStatement();
				Statement stat = (Statement) con.createStatement();
				Statement stt = (Statement) con.createStatement();
				Statement statt = (Statement) con.createStatement();
				newmasterclass m = new newmasterclass();
				strating = System.currentTimeMillis();
				
				
				
				for (k = 0; k < TestGoogleSea1.URLans.size(); k++) {
					System.out.println(k+"Data Url="+ TestGoogleSea1.URLans.get(k).toString());
					
					if (k <= 5) {
						
						
						// get the URLs
						String[] data = TestGoogleSea1.URLans.get(k).toString().split("#");
						String url1 = data[1].replaceAll("'", "");
						String stra = deTag.facest(phrase, url1, fileid);// Extracting
						dataurl.add(stra);
						// get the features
						String Title = m.GetTitle(data[1]);
						String desc = m.GetDescription(data[1]);
						if (Title != null && desc != null) {
							System.out.println(k + "th TITLE is \t" + Title);
							System.out.println(k + "th desc is \t" + desc);
							ResultSet rs = st1
									.executeQuery("select count(*) from trainningdata");
							if (rs.next()) {
								id = rs.getInt(1) + 1;
							}
							String url = data[1].replaceAll("'", "");
							String str = deTag.facest(phrase, url, fileid);// Extracting
							docdata.add(str);
							StringTokenizer st = new StringTokenizer(str, ".");
							String tokenstr = null;
							while (st.hasMoreTokens()) {
								tokenstr = st.nextToken();
								cslist.add(tokenstr);
								addlist(tokenstr, k);

							}
							for (int j = 0; j < cslist.size(); j++) {
								String s1 = cslist.get(j);
								datacomma = cslist.get(j).split(",");
								if (datacomma.length >= 3) {
									datalist.add(cslist.get(j));
								} else {
								}
								datastr = cslist.get(j).split(" ");
								if (s1.indexOf(",") == -1) {
								} else {
									if (datastr.length >= 3) {
										for (String w : datastr) {
											if (w.indexOf(",") == -1) {
											} else {
												Pattern p = Pattern
														.compile("[0-9]");
												Matcher matcher = p.matcher(w);
												if (matcher.find()) {
												} else {
													finalname += w.replace("(",
															"")
															.replace(")", "");
												}
											}
										}

									}
								}

							}
							System.out.println(k + "Final List Facets:="
									+ finalname);

							finaldata.add(finalname);
							finalname = "";
							cslist.clear();
							datastr = new String[0];
							datacomma = new String[0];
							// Append data into URL set
							st1.executeUpdate("insert into trainningdata values('"
									+ id
									+ "','"+Username+"','"
									+ phrase
									+ "','"
									+ data[1].replaceAll("'", "")
									+ "','"
									+ Title.replaceAll("'", "")
									+ "','"
									+ desc.replaceAll("'", "") + "','"+today+"')");
							System.out.println("Done");
							fileid++;
						} else {
							
							 if (Title == null) {
							 Title="null";
							System.out.println(k + "th TITLE is \t" + Title);
							System.out.println(k + "th desc is \t" + desc);
							desc = "null";
							ResultSet rs = st1
									.executeQuery("select count(*) from trainningdata");
							if (rs.next()) {
								id = rs.getInt(1) + 1;
							}
							String url = data[1].replaceAll("'", "");
							String str = deTag.facest(phrase, url, fileid);// Extracting
							docdata.add(str);
							StringTokenizer st = new StringTokenizer(str, ".");
							String tokenstr = null;
							while (st.hasMoreTokens()) {
								tokenstr = st.nextToken();
								cslist.add(tokenstr);
								addlist(tokenstr, k);
							}
							for (int j = 0; j < cslist.size(); j++) {

								String s1 = cslist.get(j);
								datacomma = cslist.get(j).split(",");
								if (datacomma.length >= 3) {
									datalist.add(cslist.get(j));
								} else {
								}
								datastr = cslist.get(j).split(" ");
								if (s1.indexOf(",") == -1) {

								} else {

									if (datastr.length >= 3) {
										for (String w : datastr) {
											if (w.indexOf(",") == -1) {
											} else {

												Pattern p = Pattern
														.compile("[0-9]");
												Matcher matcher = p.matcher(w);
												if (matcher.find()) {
												} else {
													finalname += w.replace("(",
															"")
															.replace(")", "");
												}
											}
										}

									}
								}

							}

							System.out.println(k + "Final List Facest:="
									+ finalname);
							finaldata.add(finalname);
							finalname = "";
							cslist.clear();
							datastr = new String[0];
							datacomma = new String[0];
							// Append data into URL set
							st1.executeUpdate("insert into trainningdata values('"
									+ id
									+ "','"+Username+"','"
									+ phrase
									+ "','"
									+ data[1].replaceAll("'", "")
									+ "','"
									+ Title.replaceAll("'", "")
									+ "','"
									+ desc.replaceAll("'", "") + "','"+today+"')");
							System.out.println("Done");
							fileid++;
							 }
							 else
							 {
								 System.out.println(k + "th TITLE is \t" + Title);
									System.out.println(k + "th desc is \t" + desc);
									desc = "null";
									ResultSet rs = st1
											.executeQuery("select count(*) from trainningdata");
									if (rs.next()) {
										id = rs.getInt(1) + 1;
									}
									String url = data[1].replaceAll("'", "");
									String str = deTag.facest(phrase, url, fileid);// Extracting
									docdata.add(str);
									StringTokenizer st = new StringTokenizer(str, ".");
									String tokenstr = null;
									while (st.hasMoreTokens()) {
										tokenstr = st.nextToken();
										cslist.add(tokenstr);
										addlist(tokenstr, k);
									}
									for (int j = 0; j < cslist.size(); j++) {

										String s1 = cslist.get(j);
										datacomma = cslist.get(j).split(",");
										if (datacomma.length >= 3) {
											datalist.add(cslist.get(j));
										} else {
										}
										datastr = cslist.get(j).split(" ");
										if (s1.indexOf(",") == -1) {

										} else {

											if (datastr.length >= 3) {
												for (String w : datastr) {
													if (w.indexOf(",") == -1) {
													} else {

														Pattern p = Pattern
																.compile("[0-9]");
														Matcher matcher = p.matcher(w);
														if (matcher.find()) {
														} else {
															finalname += w.replace("(",
																	"")
																	.replace(")", "");
														}
													}
												}

											}
										}

									}

									System.out.println(k + "Final List Facest:="
											+ finalname);
									finaldata.add(finalname);
									finalname = "";
									cslist.clear();
									datastr = new String[0];
									datacomma = new String[0];
									// Append data into URL set
									st1.executeUpdate("insert into trainningdata values('"
											+ id
											+ "','"+Username+"','"
											+ phrase
											+ "','"
											+ data[1].replaceAll("'", "")
											+ "','"
											+ Title.replaceAll("'", "")
											+ "','"
											+ desc.replaceAll("'", "") + "','"+today+"')");
									System.out.println("Done");
									fileid++;
							 }
						}// else loop end
						
					}
				}// url list for loop end
				System.out.println("Facets List:=" + finaldata.size()
						+ "All Data List:=" + datalist.size());
				for (int i = 0; i < datalist.size(); i++) {
					String urldata = datalist.get(i);// all data url
					// System.out.println("No of List:="+i);
					for (int j = 0; j < finaldata.size(); j++) {
						String element = finaldata.get(j);// facets name
						css = vcs.GetSimilarity(element.toString()
								.toLowerCase(), urldata.toLowerCase());
						toplist.add(css);
					}
					// count max cvs get
					int index = addh(toplist);// call vcs max values get
					vcs1 = vcs1 + toplist.get(0);
					vcs2 = vcs2 + toplist.get(1);
					vcs3 = vcs3 + toplist.get(2);
					vcs4 = vcs4 + toplist.get(3);
					vcs5 = vcs5 + toplist.get(4);
					vcs6 = vcs6 + toplist.get(5);
					
//					vcs7=vcs7+toplist.get(6);
//					vcs8=vcs8+toplist.get(7);
//					vcs9=vcs9+toplist.get(8);
//					vcs10=vcs10+toplist.get(9);
					topindex.add(index);
					toplist.clear();
				}
//				System.out.println("vcs1:=" + vcs1);
//				System.out.println("vcs2:=" + vcs2);
//				System.out.println("vcs3:=" + vcs3);
//				System.out.println("vcs4:=" + vcs4);
//				System.out.println("vcs5:=" + vcs5);
//				System.out.println("vcs6:=" + vcs6);
				finalvcs = vcs1 + vcs2 + vcs3 + vcs4 + vcs5 + vcs6;//+vcs7+vcs8+vcs9+vcs10;
				endingtime = System.currentTimeMillis();
				totalvcs = endingtime - strating;
				System.out.println("Final Vcs count:="+df2.format(finalvcs/datalist.size()) + "\tStrating time:=" + strating
						+ "\tEnding Time:=" + endingtime + "\tTotal Time:="
						+ totalvcs);

				// count tf
				TFIDFCalculator calculator = new TFIDFCalculator();
				for (int i = 0; i < docdata.size(); i++) {
					counttfidf(i);
				}
				// count tfidf
				Thread.sleep(10000);
				for (int i = 0; i < tflist.size(); i++) {
					tfIdf = calculator.tfIdf(tflist.get(i), documents, word);
					finaltfidf=tfIdf+finaltfidf;
					// System.out.println(i+"Tf Count:="+tflist.get(i)+"TfIdf Count:="+tfIdf);
				}
				endingtimetf = System.currentTimeMillis();
				totaltf = endingtimetf - strating;
				System.out.println("Final TfIdf:="+df2.format(finaltfidf) + "\tStrating time:=" + strating
						+ "\tEnding Time:=" + endingtimetf + "\tTotal Time TfIdf:="
						+ totaltf);
				
				stt.executeUpdate("insert into countmaster values('"
						+ phrase + "','" + df2.format(finalvcs/datalist.size()).trim() + "','"
						+ totalvcs + "','"
						+ df2.format(finaltfidf) + "','"
						+ totaltf + "')");
						
				
				
				String cluster = "", clustercount = "";
				for (Integer temp : topindex) {
					Integer count = map.get(temp);
					map.put(temp, (count == null) ? 1 : count + 1);
					cluster = map.keySet().toString().replace("[", "")
							.replace("]", "");
					clustercount = map.values().toString().replace("[", "")
							.replace("]", "");
					
				}
				System.out.println("Count:-" + cluster + "Total:-"
						+ clustercount);
				String[] urlno=cluster.split(",");
				String[] clusterno=clustercount.split(",");
				for (int i = 0; i < clusterno.length; i++) {
				
					statt.executeUpdate("insert into countcluster values('"
							+ phrase + "','" + urlno[i].trim() + "','"
							+ clusterno[i].trim() + "')");
				}
				
				
				
				
				
				int totalcluster;
				double percentage;
				int fx = datalist.size();
				String[] urlindex = cluster.split(",");
				String[] clustertotal = clustercount.split(",");
				for (int i = 0; i < urlindex.length; i++) {
					totalcluster = Integer.parseInt(clustertotal[i].trim());
					percentage = totalcluster * 100 / fx;
					String url = dataurl.get(i);
					// System.out.println("Count:-"+clustertotal[i].trim()+"Total:-"+percentage+"Fx:="+fx);
					stat.executeUpdate("insert into facetmaster values('"
							+ phrase + "','" + url + "','"
							+ clustertotal[i].trim() + "','"
							+ finaldata.get(i).replaceAll("'", "") + "','"
							+ percentage + "')");
				}
			}

			newmasterclass.doc1.clear();
			newmasterclass.doc2.clear();
			newmasterclass.doc3.clear();
			newmasterclass.doc4.clear();
			newmasterclass.doc5.clear();
			newmasterclass.doc6.clear();
			Statement statt = (Statement) con.createStatement();
			
			statt.executeUpdate("insert into history values('"
					+ phrase + "','" + Username + "','"
					+ today + "')");
//			newmasterclass.doc7.clear();
//			newmasterclass.doc8.clear();
//			newmasterclass.doc9.clear();
//			newmasterclass.doc10.clear();
		} catch (Exception e) {
			System.err.println("master function");
			e.printStackTrace();
		}
		return no;

	}

	// create cluster
	public static int addh(ArrayList<Double> list) {

		Double obj = Collections.max(list);
		int index = list.indexOf(obj);
		System.out.println("Index Url :=" + index + "\tMax Values:=" + obj);
		return index;

	}

	public static void addlist(String str, int i) {
		if (i == 0) {
			doc1.add(str);
		}
		if (i == 1) {
			doc2.add(str);
		}
		if (i == 2) {
			doc3.add(str);
		}
		if (i == 3) {
			doc4.add(str);
		}
		if (i == 4) {
			doc5.add(str);
		}
		if (i == 5) {
			doc6.add(str);
		}
//		if (i == 6) {
//			doc7.add(str);
//		}
//		if (i == 7) {
//			doc8.add(str);
//		}
//		if (i == 8) {
//			doc9.add(str);
//		}
//		if (i == 9) {
//			doc10.add(str);
//		}
		
	}

	public static void counttfidf(int i) {
		TFIDFCalculator calculator = new TFIDFCalculator();

		if (i == 0) {
			// System.out.println("Doc1 Size:="+doc1.size());
			documents.add(doc1);
			tf = calculator.tfnew(doc1, word);
			tflist.add(tf);

		} else if (i == 1) {
			// System.out.println("Doc2 Size:="+doc2.size());
			documents.add(doc2);
			tf = calculator.tfnew(doc2, word);
			tflist.add(tf);

		} else if (i == 2) {
			// System.out.println("Doc3 Size:="+doc3.size());
			documents.add(doc3);
			tf = calculator.tfnew(doc3, word);
			tflist.add(tf);

		} else if (i == 3) {
			// System.out.println("Doc4 Size:="+doc4.size());
			documents.add(doc4);
			tf = calculator.tfnew(doc4, word);
			tflist.add(tf);

		} else if (i == 4) {
			// System.out.println("Doc5 Size:="+doc5.size());
			documents.add(doc5);
			tf = calculator.tfnew(doc5, word);
			tflist.add(tf);

		} else if (i == 5) {
			// System.out.println("Doc6 Size:="+doc6.size());
			documents.add(doc6);
			tf = calculator.tfnew(doc6, word);
			tflist.add(tf);

		}
			//else if (i == 6) {
//			// System.out.println("Doc6 Size:="+doc6.size());
//			documents.add(doc7);
//			tf = calculator.tfnew(doc7, word);
//			tflist.add(tf);
//
//		}
//		else if (i == 7) {
//			// System.out.println("Doc6 Size:="+doc6.size());
//			documents.add(doc8);
//			tf = calculator.tfnew(doc8, word);
//			tflist.add(tf);
//
//		}
//		else if (i == 8) {
//			// System.out.println("Doc6 Size:="+doc6.size());
//			documents.add(doc9);
//			tf = calculator.tfnew(doc9, word);
//			tflist.add(tf);
//
//		}
//		else if (i == 9) {
//			// System.out.println("Doc6 Size:="+doc6.size());
//			documents.add(doc10);
//			tf = calculator.tfnew(doc10, word);
//			tflist.add(tf);
//
//		}

	}

	public static void countvcs(int i, double vcs) {
		if (i == 0) {
			vcs1 = vcs1 + vcs;
			System.out.println("vcs1:=" + vcs1);

		} else if (i == 1) {
			vcs2 = vcs2 + vcs;
			System.out.println("vcs2:=" + vcs2);

		} else if (i == 2) {
			vcs3 = vcs3 + vcs;
			System.out.println("vcs3:=" + vcs3);

		} else if (i == 3) {
			// System.out.println("Doc4 Size:="+doc4.size());
			vcs4 = vcs4 + vcs;
			System.out.println("vcs4:=" + vcs4);

		} else if (i == 4) {
			// System.out.println("Doc5 Size:="+doc5.size());
			vcs5 = vcs5 + vcs;
			System.out.println("vcs5:=" + vcs5);

		} else if (i == 5) {
			// System.out.println("Doc6 Size:="+doc6.size());
			vcs6 = vcs6 + vcs;
			System.out.println("vcs6:=" + vcs6);

		}

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
