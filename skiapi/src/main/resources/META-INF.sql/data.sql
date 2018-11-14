INSERT INTO voivodeships (id, name) values (1,'dolnośląskie')
INSERT INTO voivodeships (id, name) values (2,'lubelskie')
INSERT INTO voivodeships (id, name) values (3,'łódzkie')
INSERT INTO voivodeships (id, name) values (4,'małopolskie')
INSERT INTO voivodeships (id, name) values (5,'mazowieckie')
INSERT INTO voivodeships (id, name) values (6,'podkarpackie')
INSERT INTO voivodeships (id, name) values (7,'śląskie')
INSERT INTO voivodeships (id, name) values (8,'świętokrzyskie')
INSERT INTO voivodeships (id, name) values (9,'warmińsko-mazurskie')
INSERT INTO voivodeships (id, name) values (10,'wielkopolskie')

INSERT INTO counties (id, name, voivodeship) values (1,'jeleniogórski',1)
INSERT INTO counties (id, name, voivodeship) values (2,'kłodzki',1)
INSERT INTO counties (id, name, voivodeship) values (3,'lubański',1)
INSERT INTO counties (id, name, voivodeship) values (4,'wałbrzyski',1)
INSERT INTO counties (id, name, voivodeship) values (5,'janowski',2)
INSERT INTO counties (id, name, voivodeship) values (6,'radomszczański',3)
INSERT INTO counties (id, name, voivodeship) values (7,'gorlicki',4)
INSERT INTO counties (id, name, voivodeship) values (8,'limanowski',4)
INSERT INTO counties (id, name, voivodeship) values (9,'myślenicki',4)
INSERT INTO counties (id, name, voivodeship) values (10,'nowosądecki',4)
INSERT INTO counties (id, name, voivodeship) values (11,'nowotarski',4)
INSERT INTO counties (id, name, voivodeship) values (12,'suski',4)
INSERT INTO counties (id, name, voivodeship) values (13,'tatrzański',4)
INSERT INTO counties (id, name, voivodeship) values (14,'wadowicki',4)
INSERT INTO counties (id, name, voivodeship) values (15,'Warszawa',5)
INSERT INTO counties (id, name, voivodeship) values (16,'bieszczadzki',6)
INSERT INTO counties (id, name, voivodeship) values (17,'krośnieński',6)
INSERT INTO counties (id, name, voivodeship) values (18,'Przemyśl',6)
INSERT INTO counties (id, name, voivodeship) values (19,'bielski',7)
INSERT INTO counties (id, name, voivodeship) values (20,'cieszyński',7)
INSERT INTO counties (id, name, voivodeship) values (21,'żywiecki',7)
INSERT INTO counties (id, name, voivodeship) values (22,'ostrowiecki',8)
INSERT INTO counties (id, name, voivodeship) values (23,'gołdapski',9)
INSERT INTO counties (id, name, voivodeship) values (24,'mrągowski',9)
INSERT INTO counties (id, name, voivodeship) values (25,'Poznań',10)

INSERT INTO boroughs (id, name, county) values (1,'Szklarska Poręba',1)
INSERT INTO boroughs (id, name, county) values (2,'Karpacz',1)
INSERT INTO boroughs (id, name, county) values (3,'Stronie Śląskie',2)
INSERT INTO boroughs (id, name, county) values (4,'Duszniki-Zdrój',2)
INSERT INTO boroughs (id, name, county) values (5,'Świeradów-Zdrój',3)
INSERT INTO boroughs (id, name, county) values (6,'Boguszów-Gorce',4)
INSERT INTO boroughs (id, name, county) values (7,'Chrzanów',5)
INSERT INTO boroughs (id, name, county) values (8,'Kamieńsk',6)
INSERT INTO boroughs (id, name, county) values (9,'Sękowa',7)
INSERT INTO boroughs (id, name, county) values (10,'Laskowa',8)
INSERT INTO boroughs (id, name, county) values (11,'Limanowa',8)
INSERT INTO boroughs (id, name, county) values (12,'Mszana Dolna',8)
INSERT INTO boroughs (id, name, county) values (13,'Niedźwiedź',8)
INSERT INTO boroughs (id, name, county) values (14,'Myślenice',9)
INSERT INTO boroughs (id, name, county) values (15,'Sułkowice',9)
INSERT INTO boroughs (id, name, county) values (16,'Krynica Zdrój',10)
INSERT INTO boroughs (id, name, county) values (17,'Piwniczna-Zdrój-Muszyna',10)
INSERT INTO boroughs (id, name, county) values (18,'Rytro',10)
INSERT INTO boroughs (id, name, county) values (19,'Czorsztyn',11)
INSERT INTO boroughs (id, name, county) values (20,'Spytkowice',11)
INSERT INTO boroughs (id, name, county) values (21,'Szczawnica',11)
INSERT INTO boroughs (id, name, county) values (22,'Zawoja',12)
INSERT INTO boroughs (id, name, county) values (23,'Bukowina Tatrzańska',13)
INSERT INTO boroughs (id, name, county) values (24,'Kościelisko',13)
INSERT INTO boroughs (id, name, county) values (25,'Poronin',13)
INSERT INTO boroughs (id, name, county) values (26,'Zakopane',13)
INSERT INTO boroughs (id, name, county) values (27,'Andrychów',14)
INSERT INTO boroughs (id, name, county) values (28,'Warszawa',15)
INSERT INTO boroughs (id, name, county) values (29,'Ustrzyki Dolne',16)
INSERT INTO boroughs (id, name, county) values (30,'Rymanów',17)
INSERT INTO boroughs (id, name, county) values (31,'Przemyśl',18)
INSERT INTO boroughs (id, name, county) values (32,'Bielsko-Biała',19)
INSERT INTO boroughs (id, name, county) values (33,'Szczyrk',19)
INSERT INTO boroughs (id, name, county) values (34,'Istebna',20)
INSERT INTO boroughs (id, name, county) values (35,'Ustroń',20)
INSERT INTO boroughs (id, name, county) values (36,'Wisła',20)
INSERT INTO boroughs (id, name, county) values (37,'Czernichów',21)
INSERT INTO boroughs (id, name, county) values (38,'Jeleśnia',21)
INSERT INTO boroughs (id, name, county) values (39,'Rajcza',21)
INSERT INTO boroughs (id, name, county) values (40,'Bałtów',22)
INSERT INTO boroughs (id, name, county) values (41,'Gołdap',23)
INSERT INTO boroughs (id, name, county) values (42,'Mikołajki',24)
INSERT INTO boroughs (id, name, county) values (43,'Poznań',25)

INSERT INTO ski_run_levels(id,name) values (1,'czerwona');
INSERT INTO ski_run_levels(id,name) values (2,'zielona');
INSERT INTO ski_run_levels(id,name) values (3,'czarna');

INSERT INTO ski_run_types(id,name) values (1,'orczykowa');
INSERT INTO ski_run_types(id,name) values (2,'krzesełkowa');
INSERT INTO ski_run_types(id,name) values (3,'linowa');
INSERT INTO ski_run_types(id,name) values (4,'gondolowa');
INSERT INTO ski_run_types(id,name) values (5,'linowo-terenowa');
INSERT INTO ski_run_types(id,name) values (6,'bezpodporowa');
INSERT INTO ski_run_types(id,name) values (7,'koszykowa');
INSERT INTO ski_run_types(id,name) values (8,'ruchomy chodnik');

INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (1,'SkiArena Szrenica','Turystyczna 25A','Szklarska Poręba','75 717 30 35','-','https://skimap.org/data/1865/1/1301281553.jpg',50.833333333333,15.533333333333,1,'http://sudetylift.com.pl/zima/wp-content/uploads/sites/2/szrenica_02-938x703.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (2,'Kompleks Narciarski Kopa w Karpaczu','Kopa','Karpacz','75 761 92 84','http://kopa.com.pl','mock',50.767083, 15.729083,2,'http://kopa.com.pl/public/ck/userfiles/images/kopa-karpacz.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (3,'Stacja Narciarska Biały Jar w Karpaczu','Turystyczna 5','Karpacz','https://www.winterpol.eu/karpacz','mock','mock',50.772833, 15.738056,2,'https://d-pt.ppstatic.pl/kadry/k/r/1/dc/78/586defb26751e_o,size,1068x623,q,71,h,de600d.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (4,'Ośrodek Narciarski Czarna Góra','Sienna 11','Stronie Śląskie','74 884 34 06','https://czarnagora.pl','https://upload.wikimedia.org/wikipedia/commons/2/2e/Mapa_o%C5%9Brodka.jpg',50.260134, 16.819212,3,'https://d-pt.ppstatic.pl/kadry/k/r/1/78/af/586e0a0e07c4d_o,size,1068x623,q,71,h,8b2927.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (5,'Stacja Narciarska Kamienica','Kamienica 1a','Stronie Śląskie','74 814 32 85','http://www.snkamienica.pl','mock',50.251111, 16.886389,3,'http://www.snkamienica.pl/images/kamery/kamery.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (6,'Stacja Narciarska Zieleniec','Zieleniec 72','Duszniki-Zdrój','74 866 04 39','https://www.zieleniec.pl','mock',50.339139, 16.383056,4,'http://bi.gazeta.pl/im/ca/8e/10/z17362122Q,Zieleniec.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (7,'Ośrodek Ski & Sun Świeradów-Zdrój','Źródlana 7','Świeradów-Zdrój','75 615 20 20','http://skisun.pl','mock',50.910417, 15.319722	,5,'https://img.grouponcdn.com/deal/fu88n6cCbSJe2sjy7KVo/dT-700x420/v1/c700x420.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (8,'Ośrodek Sportowo-Rekreacyjny Góra Dzikowiec w Boguszowie-Gorcach','Bema','Boguszów-Gorce','74 844 70 32','http://www.dzikowiec.info','mock',50.724389, 16.219833,6,'http://wyjade.pl/resources/miejsca/542/stok-dzikowiec.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (9,'Narciarski Raj w Chrzanowie','Chrzanów Czwarty','Chrzanów Czwarty','600 656 465','http://www.rzetelski.com.pl','mock',50.779811, 22.625372,7,'https://i.ytimg.com/vi/L400Ov-Qg4Q/maxresdefault.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (10,'Ośrodek Sportu i Rekreacji Góra Kamieńsk','Huby Ruszczyńskie','Kamieńsk','44 737 77 30','http://gorakamiensk.info','mock',51.230833, 19.436722,8,'https://static.polskieszlaki.pl/zdjecia/wycieczki/2016-07/osrodek-rekreacyjno-narciarski-gora-kamiensk-1-1466495327.jpg')


INSERT INTO ski_runs (id,length,height_difference, resort) values (1,2750,429,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (2,2393,508,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (3,80,17,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (4,1390,434,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (5,636,118,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (6,835,172,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (7,800,221,8);
INSERT INTO ski_runs (id,length,height_difference, resort) values (8,2500,443,7);

INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (1,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (2,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (3,6);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (4,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (5,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (6,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (7,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (8,4);


INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (1,3);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (2,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (3,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (4,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (5,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (6,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (7,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (8,1);




