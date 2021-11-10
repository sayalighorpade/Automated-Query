# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     crawler1
# Server version:               5.1.73-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2017-05-26 17:59:03
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for crawler1
CREATE DATABASE IF NOT EXISTS `crawler1` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `crawler1`;


# Dumping structure for table crawler1.countcluster
CREATE TABLE IF NOT EXISTS `countcluster` (
  `searchword` text,
  `urlno` bigint(100) DEFAULT NULL,
  `clustercount` bigint(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table crawler1.countcluster: 6 rows
/*!40000 ALTER TABLE `countcluster` DISABLE KEYS */;
INSERT INTO `countcluster` (`searchword`, `urlno`, `clustercount`) VALUES ('rohit', 0, 32), ('rohit', 1, 15), ('rohit', 2, 54), ('rohit', 3, 46), ('rohit', 4, 5), ('rohit', 5, 57);
/*!40000 ALTER TABLE `countcluster` ENABLE KEYS */;


# Dumping structure for table crawler1.countmaster
CREATE TABLE IF NOT EXISTS `countmaster` (
  `searchword` text,
  `vcs` text,
  `vcstime` bigint(100) DEFAULT NULL,
  `tfidf` text,
  `tfidftime` bigint(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table crawler1.countmaster: 1 rows
/*!40000 ALTER TABLE `countmaster` DISABLE KEYS */;
INSERT INTO `countmaster` (`searchword`, `vcs`, `vcstime`, `tfidf`, `tfidftime`) VALUES ('rohit', '0.24', 47638, '0.04', 57837);
/*!40000 ALTER TABLE `countmaster` ENABLE KEYS */;


# Dumping structure for table crawler1.facetmaster
CREATE TABLE IF NOT EXISTS `facetmaster` (
  `searchword` text,
  `url` text,
  `clusterno` bigint(20) DEFAULT NULL,
  `facetlist` text,
  `percentage` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table crawler1.facetmaster: 6 rows
/*!40000 ALTER TABLE `facetmaster` DISABLE KEYS */;
INSERT INTO `facetmaster` (`searchword`, `url`, `clusterno`, `facetlist`, `percentage`) VALUES ('sachin tendulkar', 'https://en.wikipedia.org/wiki/Sachin_Tendulkar', 200, 'Wikipedia,navigation,surname,Tendulkar,Mumbai,Cricket,medium,break,Parliament,ESPNcricinfo,captain,eleven,sixteen,centuries,International,cricket,career,time,Bradman,time,career,Cup,tournament,achievement,honour,respectively,Ratna,Sabha,match,total,Dadar,father,Tendulkar,mother,Rajni,director,Ajit,Although,boy,bully,tennis,tendencies,Achrekar,repute,Park,meeting,him,playing,time,Sachin,unobserved,this,exhausted,stumps,dismissed,uncle,Park,period,AnjaliMeanwhile,school,circles,cricket,cricket,tournament,bowler,Lillee,wickets,unimpressed,Bombay,later,me,"Kambli,Trophy,tournament,However,matches,Gavaskar,later,days,match,time,Dev,Trophies,BCCI,season,twice,final,innings,Ranji,Irani,Trophy,Yorkshire,team,McDermott,year,him,runs,Younis,match,Sialkot,Younis,Peshawar,series,balls,all,series,played,tour,August,Manchester,opener,Gavaskar,hundred,tall,Cup,Sydney,fast,Hughes,you,peak,Holi,Cup,referee,Cup,Sharjah,out,world,Tendulkar,Warne,spinner,careers,series,Sivaramakrishnan,spinner,opener,Robertson,Tests,win,India,Bevan,Waugh,Lehmann,finals,semifinals,twice,India,Pakistan,match,Akhtar,crowd,final,Pakistan,series,However,win,collapse,Tendulkar,father,father,However,However,term,Australia,Tendulkar,however,defeat,Africa,resigned,captain,which,temporary,England,However,captain,conversation,Dhoni,Park,Elizabeth,appealing,can,conditions,Gilchrist,followed,ODIs,Indies,well,Spain,innings,match,Then,sequence,However,haul,year,bowler,centurion,series,Sydney,match,form,cricket,evening,match,Tendulkar,year,Kotla,century,this,hostile,Lahore,ground,Wankhede,credit,selection,match,out,Cup,report,order,innings,emotion,Indies,Tendulkar,Bangladesh,result,Chappell,Greg,Bangladesh,match,England,Pakistan,series,time,Trophy,form,Tests,Melbourne,Sydney,overall,Perth,WACA,Oval,draw,innings,India,Australia,tournament,[originalHobart,Tests,Bangladesh,Cup,However,innings,Lanka,However,India,form,Test,fourth,injury,attacks,Test,Mumbai,match,match,Mohali,ODIs,matches,them,Zealand,series,Test,century,third,India,final,Africa,Indies,October,match,hundred,target,Hauritz,collapsed,match,followed,Test,drawn,Tests,Test,Africa,Test,Tests,series,out,April,Bangladesh,India,centuries,victory,June,cricket,bowler,Lawson,Incidentally,milestone,this,went,restaurant,service,century,Bangladesh,form,home,Tendulkar,Sixes,England,Patil,speculation,however,Vahora,Ground,Saurashtra,Mumbai,cricket,match,England,news,Pakistan,it",Africa,cricket,Mumbai,Indies,cricket,politics,side,player,team,League,tournament,IPL,Kerala,runs,bats,hand,India,hard,drive,Gavaskar,AFP,Bradman,time,biography,technique,production,Tendulkar,wife,Jessie,crease,style,because,firstly,and,secondly,career,Chappell,player,now,repertoire,sweep,heads,bowler,pace,spin,period,bowling,Tests,taker,Chaudhary,globe,crowds,remains,distance,However,God,mistakes,Yet,newspapers,Chaudhary,Bihar,Mumbai,lead,Sheridan,sachin_rt,Tussauds,Tests,runs,Internationals,Tests,First-class,wins,times,runs,times,cricket,[citationAustralia,Cup,Award,Ratna,Shri,Award,Vibhushan,Ratna,Cricket,July,Australia,paediatrician,champion,Annabel,courtship,children,Arjun,seamer,batsmen,side,team,Puttaparthi,birthday,death,Puttaparthi,Colaba,Mulund,X,Wadekar,May,Apnalaya,mother-in-law,facilities,students,orders,one,Inferno,Murray,Religion,Santhanam,Tendulkar,Monday,Panth,Murray,Dreams,White,Bal,Gupta,Test,Bradman,Affairs,Rao,Thani,Mishra,brother,Baliga,Williams,Krishnan,Booth,Naik,Williams,badshah,Bhatia,India,Stadium,Miller,Williamson,Match,India,Series,Otway,Saltau,Cup,Bal,India,Stadium,Ramchand,Report,police,Williamson,Ramchand,father,Sahi,McGregor,Press,Melbourne,Jaishankar,Ugra,Kolkata,Prabhu,Kingston,practice,Lokapally,Mukhopadhyay,"Sachin,big,Sydney,worry,elbow,Weaver,,Tendulkar,elbow,Lynch,tribulations,Premachandran,Premachandran,Tendulkar,watch,Byrant,Lumpur,Dhaka,in,Cup,Belfast,"Statistics,England,"Statistics,Series,Test,Vivek,Sridhar,Trophy,Vivek,Sydney,Binoy,Gopalakrishna,Premachandran,Premachandran,Belfast,Vivek,Sydney,Brisbane,Alter,Bangalore,Pradhan,counting,Chennai,career,"Coverdale,Alter,Bangalore,Kumar,Kumar,McGlashan,Dwivedi,century,Mohali,Veera,Premachandran,Napier,Wellington,draw,"Tendulkar,RPS,RPS,Hemant,Rajesh,Dwivedi,Dinakar,Windies,Monga,Kumar,Sridhar,Delhi,Chittagong,Dhaka,Nagpur,Kumar,Test,Naik,Sachin,Nataranjan,Cup,Miller,Miller,returns,Sehwag,runs,"Tendulkar,Mumbai,Diwan,Ugra,Sampath,Ravindran,Rao,Rao,Suri,Tendulkar,goodbye,Mumbai,Narula,Chadband,Ambassador","International,ambassador","IbnLive",Ambassador","NDTV,Ambassador","AffairsCloud",Kelso,Live,Schedule,Fixtures,Online,Live,Sekhar,shot,talent,,Kochi,Surendran,Murzello,"Figures,First-class,captains,players,"Statistics,Soni,Sports,Sports,Directory,Affairs,Chennai,"Tendulkar,"Sachin,Saran,Chadband,Baba,celebrations,restaurant,Basu,Prabhakar,Chatterjee,Badrinath,Tagore,Media,Tendulkar,Cricket,Kolkota,Religion,Murray,Shukla,Srivastava,Pataudi,Pataudi,Rajagopalachari,Radhakrishnan,Das,Visvesvarayya,Gandhi,Patel,Azad,Tata,Nanda,Ali,Narayan,Sen,Bordoloi,Kom,Singh,Sindhu,Karmakar,Rai,XI,site,Foundation,,', 52), ('sachin tendulkar', 'https://twitter.com/sachin_rt', 51, 'Policy,Home,a,a:hover,a:focus,li:hover,li:focus,button:hover,a,a:focus,strong,strong,strong,#fff,#fff,#fff,#fff,EmojiPicker-skinToneSwatch,img:first-child:last-child,#fff,a:hover,a:focus,input:focus,textarea:focus,div[contenteditable="true"]:focus,fake-focus,div[contenteditable="plaintext-only"]:focus,s,s,li:after,li:before,Tweets,Tweets,@sachin_rtYes,bumrahThanks,added,Jaspritmessage,added,Abhishekperson,film,added,Kapiladded,Yogeshwar#SachinABillionDreams,à¤¸à¥€à¤–à¥‡à¤—à¥€night,added,Anuragachievmnts,emotions,highslows,straightadded,yuvrajpremiere,added,Geetacoming,added,atuladded,Karishmaperson,GowarikerThanks,added,Avinashlot,added,Anupampriority,added,arjunmuch,added,sulaimannight,added,Milindwishes,added,Mithun,ton,added,Kadded,BhuvneshwarDreams,well,added,Shikharmovie,much,added,Rahullocation,characters,moreHmm,app,up,about,Orange,Airtel,Videocon,Telkomsel,Indosat,time,love,about,', 13), ('sachin tendulkar', 'http://www.espncricinfo.com/india/content/player/35320.html', 73, 'a,a,Tahoma,Arial,Verdana,Mumbai,India,XI,Mumbai,Indians,Tendlya,offbreak,world,game,ODIs,Karachi,Mumbai,Gujranwala,Dhaka,Johannesburg,Mumbai,Dhaka,Johannesburg,Delhi,time,time,balance,movement,stroke-making,upright,wicket,back,condition,situation,Australia,minds,losing,bat,hundred,Trafford,hundreds,run-scorer,after,runs,remarkable,Incredibly,birthday,centuries,average,year,though,Test,followers,dimmed,slightly,body,remains,distance,Tendulkar,Kambli,out,cricket,series,Sialkot,down,up,days,WACA,April,days,runs,England,India,over,three,October,WorldTel,February-March,India,team,captaincy,February-March,blazing,India,Azharuddin,series,Bangalore,over,centuries,Headingley,February-March,Cup,Cup,champions,»August,Modena,duty,cover-drive,Sydney,draw,»August,surfaces,England,thousand,May,elbow,Lanka,Zimbabwe,cricket,Nagpur,Delhi,cricket,Mumbai,dismissed,»March,how,comeback,May,career,»August,subcontinent,worshippers,Tests,Ground,Australia,Friday,target,deliveries,award,Trophy,XI,Test,glory,attempts,win,Africa,Pakistan,tournament,centuriesFinally,hundred,equalled,internationals,format,hundreds,Tests,Indies,Stadium,Test,England,Trafford,pitch,Malcolm,Fraser,Lewis,menacing,hours,dourly,wicket,session,Australia,Perth,already,first,crease,Africa,Town,first,honour,Donald,Pollock,sessions,Australia,Chennai,arrears,Tendulkar,series,assault,balance,Australia,Sharjah,run-rate,Single-handedly,difficult,target,Australia,final,later,venue,final,over,Australia,Dhaka,psyche,again,single-handedly,balls,doubt,Waugh,Bevan,Pakistan,Chennai,heroic,match,collapse,Mongia,painstaking,wicket,pull,two,way,themselves,Nadu,Mumbai,Nadu,contest,Tendulkar,charge,order,says,Africa,Bloemfontein,series,company,run,tons,savage,India,ends,placed,Pakistan,Centurion,India,hand,six,century,Australia,Sydney,Series,Australia,innings,masterclass,away,overs,order,England,Chennai,having,Test,start,track,Sehwag,Singh,chase,pressure,teenager,chase,Pakistan,Tendulkar,Australia,Hyderabad,Hyderabad,it,Tendulkar,balls,risk,ground,flicks,heartbreak,Tendulkar,this,Africa,Gwalior,waiting,cramps,innings,Gwalior,Pathan,well,Africa,Town,Newlands,Africa,kph,off,ball,though,deliveries,obstinately,day,debate,biopic,Singh,Cricketer,players,knuckleballs,crowd,Harmison,cricket,comebacks,extension,Gayle,Bravo,roster,sideSmith,decisions,noise,seasons,season,Gayle,Bravo,roster,Also,innings?Smith,decisions,noise,straightforward,way,better,Otherwise,', 19), ('sachin tendulkar', 'https://www.facebook.com/SachinTendulkar/', 32, 'à¤ªà¤¾à¤ à¤µà¤¾,à¤ªà¤¾à¤ à¤µà¤¾,à¤†à¤µà¤¡à¤²à¥‡à¤›à¤¾à¤¯à¤¾à¤šà¤¿à¤¤à¥à¤°à¥‡,à¤µà¥à¤¹à¤¿à¤¡à¤¿à¤“,you,you,Flights,us,letter,Flights,us,years,khele,Zealand,Also,out,', 8), ('sachin tendulkar', 'http://www.cricbuzz.com/profiles/25/sachin-tendulkar', 9, 'Ranking,Age,Trophy,matches,England,League,Indies,Mumbai,Indians,Mumbai,XI,India,Club,people,ability,Stadium,Stadium,Stadium,Stadium,Stadium,Stadium,Stadium,Stadium,people,ability,childhood,shots,superstar,debut,fashion,cricket,Akram,dozens,Internationals,anyone,centuries,decades,successes,Tendulkar,triumph,Cup,ODIs,though,fans,style,cricket,age,colour,day,after,Trophy,Sachin,play-offs,com,functionmessage,file,"Application",EventLabel:sFormattedMessage,event:', 2), ('sachin tendulkar', 'https://sports.ndtv.com/cricket/players/14-sachin-tendulkar-playerprofile', 18, 'Player,India|SachinStats,Ranking,montserrat,sans-serif;font-weight:Freely,Sindhu,Nehwal,Mumbai,Years,Months,PlayedIndia,A,B,Blue,XI,Seniors,India,World,XI,Zone,Yorkshire,Mumbai,Mumbai,Club,Span[Test,[ODI,Cup,[IPL,[CL,player,maxim,player,Sindhu,Nehwal,player,maxim,player,prodigy,decades,runs,way,batsmen,undeniable,India,Ratna,Garage,Open,', 4), ('rohit', 'http://www.cricbuzz.com/profiles/576/rohit-sharma', 32, 'Ranking,Age,Trophy,matches,England,League,Indies,PlaceBansod,Nagpur,InformationTeamsMumbai,Green,A,Chargers,India,Indians,Indians,Firstly,Secondly,Gardens,Stadium,Club,Stadium,Kingsmead,Ground,Gardens,Stadium,Firstly,Secondly,shots,However,work,Australia,series,However,bat,time,one,too,irresponsible,fate,while,However,failures,England,confirmed,game,November,time,fashion,Mumbai,ODIs,However,earlier,while,return,Gardens,Rohit,four,Australia,However,runs,com,functionmessage,file,"Application",EventLabel:sFormattedMessage,event:', 15), ('rohit', 'https://en.wikipedia.org/wiki/Rohit_Sharma', 15, 'Wikipedia,revision,navigation,uses,Maharashtra,IndiaNicknameRo,Hitman,Cricinfo,team,debut,Gardens,Kolkata,India,fame,Bansod,Nagpur,parents,brother,School,recollects,it,penny,bit,tournaments,followed,A,Agarkar,Indians,Belfast,Pakistan,Here,However,Raina,eventually,However,eleven,injury,debut,batsman,Raina,Cup,Tendulkar,rested,Singh,followed,Stadium,balls,sixes,series,Gardens,innings,ODI,India,Stadium,feat,October,tour,balls,over,auction,cricket,Gardens,fours,sixes,Club,Oval,Stadium,Stadium,Stadium,Gardens,Ground,Gabba,hundred,Award,ODIs,Africa,Cheeku,me,ton,Gwalior,Darwin,Monga,Mumbai,Belfast,Match,Durban,Johannesburg,Jaipur,Series,Sydney,Rohit,cricket,"Tendulkar,Yuvraj,Kingston,Chennai,says,Gambhir,history,"Rohit,League,Hopefully,Mumbai,League,League,League,League,League,Rahul,Binny,hundreds,Indies,Gardens,Kolkata,Series,Series,Series,Series,Series,Series,Cup,Australia,Brisbane,Series,Series,Series,Series,match,E,Match,Cup,Cup,Ratna,Williamson,Broad,Southee,squad,site,Foundation,,', 7), ('rohit', 'https://www.facebook.com/RohitSharmaOfficialPage/', 54, 'à¤ªà¤¾à¤ à¤µà¤¾,à¤ªà¤¾à¤ à¤µà¤¾,à¤†à¤µà¤¡à¤²à¥‡à¤›à¤¾à¤¯à¤¾à¤šà¤¿à¤¤à¥à¤°à¥‡,à¤µà¥à¤¹à¤¿à¤¡à¤¿à¤“,Sharma,Mumbai,talent,character,simple,bounces?Guys,', 25), ('rohit', 'https://twitter.com/imro45?lang=en', 46, 'Policy,Home,a,a:hover,a:focus,li:hover,li:focus,button:hover,a,a:focus,strong,strong,strong,#fff,#fff,#fff,#fff,EmojiPicker-skinToneSwatch,img:first-child:last-child,#fff,a:hover,a:focus,input:focus,textarea:focus,div[contenteditable="true"]:focus,fake-focus,div[contenteditable="plaintext-only"]:focus,s,s,li:after,li:before,Tweets,Tweets,talent,character,,TweetGuys,added,Rishabadded,Gurkeeratadded,sachinadded,Nitishlocation,characters,moreHmm,app,up,about,Orange,Airtel,Videocon,Telkomsel,Indosat,time,love,about,', 22), ('rohit', 'http://indianexpress.com/article/sports/cricket/ipl-2017-10/rohit-sharma-is-the-strongest-person-i-know-and-am-proud-of-him-says-wife-ritika-sajdeh-4669638/', 5, 'him,â€˜moderationâ€™,away,back,shot,ready,delayed,Fadnavis,take-off,him,him,stronger,home,wrote,stronger,home,”News,weekend,Sachin,Sachin,Kapoor,Khan,Aaradhya,', 2), ('rohit', 'http://www.espncricinfo.com/indian-premier-league-2017/content/story/1098880.html', 57, 'no-repeat;background-size:cover;font-family:BentonSans,Arial,sans-serif}#cdtimerteams{font-family:BentonSansBold,Arial,sans-serif}#first-framediv,#second-frameSupergiant,final,intelligence,believes,performances,tournament,"games,unity,won,sad,team,Again,youngsters,both,finals,night,game,board,"well,that,But,field,score,pitch,Pandya,Rahane,overreach,target,runs,"yeah,happen,overs,whatever,balls,pressure,over,ball,McClenaghan,us,finals,Johnson,customer,"set,Christian,final,them,"field,course,catch,India,matches,,,,,players,results,way,capt,title,capt,mistakes,hardik,lookcareet,hetoday,constantgames,support,andtime,lookbowler,lookcoach,whoit,kumble,soIndia,matches,,,,,players,results,way,capt,title,capt,mistakes,hardik,lookcareet,hetoday,constantgames,support,andtime,lookbowler,lookcoach,whoit,kumble,sofinisher,,Bhagwan,pune,off,victory,spinners,MI,Dhoni,often,needed,season,Cricinfo,remains,Bumrah,rohith,now,winning,case,success,them,Gambhir,GMT,me,intelligence,fact,RPS,But,teeth,saying,so,contribution,player,be,than,perhaps,details,arguments,MI,fans,detractors,edition,success,article,credibility,team,deserved,catching,hits,match,finals,However,MI,prices,Khan,guys,players,inning,catches,hit,captaincy,bowlers,Bumrah,outstanding,MI,Bumrah,games,,atout,intelligence,Bumrah,Unadkar,Clearly,replacement,pressure,Coolcapricornnow,Dhoni,Mumbai,fielder,hand,cricketer,Also,,Dhaka,Mumbai,display,team,total,again,hepoint,team,unwittingly,year,point,team,unwittingly,year,display,team,total,again,heMumbai,,Dhaka,hand,cricketer,Also,final,Ashwin,better,Otherwise,', 27);
/*!40000 ALTER TABLE `facetmaster` ENABLE KEYS */;


# Dumping structure for table crawler1.history
CREATE TABLE IF NOT EXISTS `history` (
  `searchname` text,
  `username` text,
  `Date` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table crawler1.history: 1 rows
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` (`searchname`, `username`, `Date`) VALUES ('sachin tendulkar', 'jitu', '26/05/2017'), ('sachin tendulkar', 'jitu', '26/05/2017'), ('rohit', 'jitu', '26/05/2017');
/*!40000 ALTER TABLE `history` ENABLE KEYS */;


# Dumping structure for table crawler1.register
CREATE TABLE IF NOT EXISTS `register` (
  `name` varchar(100) DEFAULT NULL,
  `contactno` varchar(100) DEFAULT NULL,
  `gender` varchar(100) DEFAULT NULL,
  `emailid` varchar(100) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table crawler1.register: 2 rows
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` (`name`, `contactno`, `gender`, `emailid`, `city`, `password`) VALUES ('jitu', '8605067524', 'Male', 'pjitendra201290@gmail.com', 'Mumbai', '12345'), ('om', '8605067524', 'Male', 'admin@gmail.com', 'pune', '123456');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;


# Dumping structure for table crawler1.trainningdata
CREATE TABLE IF NOT EXISTS `trainningdata` (
  `id` int(10) NOT NULL,
  `username` text,
  `searchphrase` text NOT NULL,
  `url` text,
  `title` text,
  `description` text,
  `date` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

# Dumping data for table crawler1.trainningdata: 6 rows
/*!40000 ALTER TABLE `trainningdata` DISABLE KEYS */;
INSERT INTO `trainningdata` (`id`, `username`, `searchphrase`, `url`, `title`, `description`, `date`) VALUES (1, 'jitu', 'sachin tendulkar', 'https://en.wikipedia.org/wiki/Sachin_Tendulkar', 'Sachin Tendulkar - Wikipedia', 'null', '26/05/2017'), (2, 'jitu', 'sachin tendulkar', 'https://twitter.com/sachin_rt', 'sachin tendulkar (@sachin_rt) | Twitter', 'The latest Tweets from sachin tendulkar (@sachin_rt). Proud Indian. ÜT: 18.986431,72.823769', '26/05/2017'), (3, 'jitu', 'sachin tendulkar', 'http://www.espncricinfo.com/india/content/player/35320.html', 'Sachin Tendulkar | India Cricket | Cricket Players and Officials | ESPN Cricinfo', 'Sachin Tendulkars Cricinfo profile', '26/05/2017'), (4, 'jitu', 'sachin tendulkar', 'https://www.facebook.com/SachinTendulkar/', 'Sachin Tendulkar - ???????? | Facebook', 'Sachin Tendulkar.28,385,955 ???? · 1,147,962 ?? ????????? ???? ????.The Official Facebook page of Sachin Tendulkar.', '26/05/2017'), (5, 'jitu', 'sachin tendulkar', 'http://www.cricbuzz.com/profiles/25/sachin-tendulkar', 'Sachin Tendulkar Profile - ICC Ranking, Age, Career Info & Stats | Cricbuzz.com', 'Looking for Sachin Tendulkars career stats? Get all the information of his performance in ODI, T20, IPL & personal info about Age, height & latest ICC Rankings', '26/05/2017'), (6, 'jitu', 'sachin tendulkar', 'https://sports.ndtv.com/cricket/players/14-sachin-tendulkar-playerprofile', 'Sachin Tendulkar Profile - Cricket Player,India|Sachin Tendulkar Stats, Ranking, Records inCricket -NDTV Sports', 'Sachin TendulkarCricket Player Profile from India at NDTV Sports. Get Sachin TendulkarCricket rankings info, individual records, photos, videos, stats, and all about Sachin Tendulkar', '26/05/2017'), (7, 'jitu', 'rohit', 'http://www.cricbuzz.com/profiles/576/rohit-sharma', 'Rohit Sharma Profile - ICC Ranking, Age, Career Info & Stats | Cricbuzz.com', 'Looking for Rohit Sharmas career stats? Get all the information of his performance in ODI, T20, IPL & personal info about Age, height & latest ICC Rankings', '26/05/2017'), (8, 'jitu', 'rohit', 'https://en.wikipedia.org/wiki/Rohit_Sharma', 'Rohit Sharma - Wikipedia', 'null', '26/05/2017'), (9, 'jitu', 'rohit', 'https://www.facebook.com/RohitSharmaOfficialPage/', 'Rohit Sharma - ???????? | Facebook', 'Rohit Sharma, Mumbai, Maharashtra. 10 ?????? ????. Welcome to my page! I am part of the Indian Cricket Team and Captain of the Mumbai Indians. I love...', '26/05/2017'), (10, 'jitu', 'rohit', 'https://twitter.com/imro45?lang=en', 'Rohit Sharma (@ImRo45) | Twitter', 'The latest Tweets from Rohit Sharma (@ImRo45): "(2/2) Cant wait to watch this one! #SachinABillionDreams @sachin_rt"', '26/05/2017'), (11, 'jitu', 'rohit', 'http://indianexpress.com/article/sports/cricket/ipl-2017-10/rohit-sharma-is-the-strongest-person-i-know-and-am-proud-of-him-says-wife-ritika-sajdeh-4669638/', 'Rohit Sharma is the strongest person I know and am proud of him, says wife Ritika Sajdeh | The Indian Express', 'Rohit Sharmas wife Ritika Sajdeh said she saw him go through possibly the hardest 6 months of your life and come out stronger, faster and more determined than ever.', '26/05/2017'), (12, 'jitu', 'rohit', 'http://www.espncricinfo.com/indian-premier-league-2017/content/story/1098880.html', 'Collective might was Mumbais winning formula - Rohit Sharma |  Cricket  | ESPN Cricinfo', 'Unlike the teams 2013 and 2015 IPL title runs, in 2017 Mumbai did not rely on individual brilliance to carry them to the championship, a point of pride for Rohit Sharma', '26/05/2017');
/*!40000 ALTER TABLE `trainningdata` ENABLE KEYS */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;