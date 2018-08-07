INSERT INTO voivodeships (id, name) values (1,'małopolskie')
INSERT INTO voivodeships (id, name) values (2,'śląskie');

INSERT INTO counties (id, name, voivodeship) values (1,'żywiecki',2);
INSERT INTO counties (id, name, voivodeship) values (2,'nowotarski',1);

INSERT INTO boroughs (id, name, county) values (1,'Rajcza',1);
INSERT INTO boroughs (id, name, county) values (2,'Spytkowice',2);

INSERT INTO ski_resorts (id,name,address,city,latitude,longitude,borough)values (1,'Kompleks Beskid Spytkowice','Spytkowice 135A','Spytkowice',49.565556,19.791028,2);
INSERT INTO ski_resorts (id,name,address,city,latitude,longitude,borough)values (2,'Stacja Narciarska Zwardoń Ski','Zwardoń 5a','Zwardoń',49.507222,18.982222,1);

INSERT INTO ski_run_levels(id,name) values (2,'zielona');
INSERT INTO ski_run_levels(id,name) values (1,'czerwona');

INSERT INTO ski_run_types(id,name) values (1,'orczykowa');
INSERT INTO ski_run_types(id,name) values (2,'krzesełkowa');

INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (1,2);
INSERT INTO ski_run_ski_run_type (ski_run_id, ski_run_type_id) values (2,1);

INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (1,1);
INSERT INTO ski_run_ski_run_level (ski_run_id, ski_run_level_id) values (2,2);

-- INSERT INTO ski_runs (id,length,type,level,heightDifference) values (1,900,2,1,140);
-- INSERT INTO ski_runs (id,length,type,level,heightDifference) values (2,130,1,2,140);

INSERT INTO ski_runs (id,length,height_difference) values (1,900,140);
INSERT INTO ski_runs (id,length,height_difference) values (2,130,140);
