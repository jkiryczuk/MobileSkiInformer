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

INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (1,'SkiArena Szrenica','Turystyczna 25A','Szklarska Poręba','75 717 30 35','-ddd','https://skimap.org/data/1865/1/1301281553.jpg',50.833333333333,15.533333333333,1,'https://i.imgur.com/tnoNMPB.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (2,'Kompleks Narciarski Kopa w Karpaczu','Kopa','Karpacz','75 761 92 84','http://kopa.com.pl','mock',50.767083, 15.729083,2,'https://i.imgur.com/dGZPh8c.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (3,'Stacja Narciarska Biały Jar w Karpaczu','Turystyczna 5','Karpacz','74 8660 431','https://www.winterpol.eu/karpacz','mock',50.772833, 15.738056,2,'https://i.imgur.com/toNa1sZ.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (4,'Ośrodek Narciarski Czarna Góra','Sienna 11','Stronie Śląskie','74 884 34 06','https://czarnagora.pl','https://upload.wikimedia.org/wikipedia/commons/2/2e/Mapa_o%C5%9Brodka.jpg',50.260134, 16.819212,3,'https://i.imgur.com/I88u9BB.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (5,'Stacja Narciarska Kamienica','Kamienica 1a','Stronie Śląskie','74 814 32 85','http://www.snkamienica.pl','http:/ coś tam coś tam ',50.251111, 16.886389,3,'https://i.imgur.com/r7Z2KaO.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (6,'Stacja Narciarska Zieleniec','Zieleniec 72','Duszniki-Zdrój','74 866 04 39','https://www.zieleniec.pl','mock',50.339139, 16.383056,4,'https://i.imgur.com/25IhtDI.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (7,'Ośrodek Ski & Sun Świeradów-Zdrój','Źródlana 7','Świeradów-Zdrój','75 615 20 20','http://skisun.pl','dsadsadasdsa',50.910417, 15.319722	,5,'https://i.imgur.com/zaPlmgw.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (8,'Ośrodek Sportowo-Rekreacyjny Góra Dzikowiec w Boguszowie-Gorcach','Bema','Boguszów-Gorce','74 844 70 32','http://www.dzikowiec.info','mock',50.724389, 16.219833,6,'https://i.imgur.com/tnoNMPB.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (9,'Narciarski Raj w Chrzanowie','Chrzanów Czwarty','Chrzanów Czwarty','600 656 465','http://www.rzetelski.com.pl','mock',50.779811, 22.625372,7,'https://i.imgur.com/I88u9BB.jpg')
INSERT INTO ski_resorts (id,name,address,city,phonenumber,website, map_adress ,latitude,longitude,borough, image) values (10,'Ośrodek Sportu i Rekreacji Góra Kamieńsk','Huby Ruszczyńskie','Kamieńsk','44 737 77 30','http://gorakamiensk.info','http://gorakamiensk.info/uploads/images/zima/MAPA_Gory_Kamiensk.jpg',51.230833, 19.436722,8,'https://i.imgur.com/zaPlmgw.jpg')


INSERT INTO ski_runs (id,length,height_difference, resort) values (1,2750,429,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (2,2393,508,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (3,80,17,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (4,1390,434,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (5,636,118,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (6,835,172,1);
INSERT INTO ski_runs (id,length,height_difference, resort) values (7,800,221,8);
INSERT INTO ski_runs (id,length,height_difference, resort) values (8,2500,443,7);
INSERT INTO ski_runs (id,length,height_difference, resort) values (9,800,221,2);
INSERT INTO ski_runs (id,length,height_difference, resort) values (10,2500,443,5);
INSERT INTO ski_runs (id,length,height_difference, resort) values (11,800,221,2);
INSERT INTO ski_runs (id,length,height_difference, resort) values (12,2500,443,5);
INSERT INTO ski_runs (id,length,height_difference, resort) values (13,800,221,5);
INSERT INTO ski_runs (id,length,height_difference, resort) values (14,2500,443,5);

INSERT INTO ski_runs (id,length,height_difference, resort) values (15,2500,443,10);
INSERT INTO ski_runs (id,length,height_difference, resort) values (16,2500,443,10);
INSERT INTO ski_runs (id,length,height_difference, resort) values (17,2500,443,10);
INSERT INTO ski_runs (id,length,height_difference, resort) values (18,2500,443,3);


INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (1,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (2,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (3,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (4,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (5,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (6,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (7,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (8,4);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (9,4);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (10,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (11,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (12,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (13,4);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (14,4);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (15,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (16,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (17,1);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (18,1);


INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (1,3);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (2,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (3,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (4,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (5,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (6,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (7,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (8,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (9,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (10,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (11,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (12,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (13,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (14,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (15,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (16,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (17,2);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (18,2);


insert into cities (id,name, lat,lng) values (1,'Szczyrk', 49.713985, 19.021715);
insert into cities (id,name, lat,lng) values (2, 'Białka Tatrzańska', 49.388465, 20.105517);
insert into cities (id,name, lat,lng) values (3,'Zieleniec',50.335255, 16.389019  );
insert into cities (id,name, lat,lng) values (4,'Krynica-Zdrój',49.421373, 20.959768  );
insert into cities (id,name, lat,lng) values (5,'Szklarska Poręba', 50.826712, 15.522470 );
insert into cities (id,name, lat,lng) values (6,'Zakopane', 49.302384, 19.957672 );
insert into cities (id,name, lat,lng) values (7,'Jurgów', 49.340832, 20.137201 );
insert into cities (id,name, lat,lng) values (8,'Żywiec', 49.690090, 19.182398 );
insert into cities (id,name, lat,lng) values (9,'Nowy Targ',49.476881, 20.031835  );
insert into cities (id,name, lat,lng) values (10,'Wisła', 49.639253, 18.873622  );
insert into cities (id,name, lat,lng) values (11,'Świeradów-Zdrój', 50.912522, 15.336654 );
insert into cities (id,name, lat,lng) values (12,'Puławy', 49.497381, 21.923785 );
insert into cities (id,name, lat,lng) values (13,'Ustrzyki Dolne', 49.430752, 22.597330 );
insert into cities (id,name, lat,lng) values (14,'Wrocław',51.107079, 17.034167  );
insert into cities (id,name, lat,lng) values (15,'Kraków', 50.055803, 19.945360 );
insert into cities (id,name, lat,lng) values (16,'Krynica Zdrój', 49.418084, 20.955140  );
insert into cities (id,name, lat,lng) values (17,'Nowy Sącz', 49.617057, 20.714798 );
insert into cities (id,name, lat,lng) values (18,'Katowice', 50.265759, 19.017791  );
insert into cities (id,name, lat,lng) values (19,'Wałbrzych', 50.782770, 16.283954  );
insert into cities (id,name, lat,lng) values (20,'Warszawa', 52.227629, 21.009971 );
