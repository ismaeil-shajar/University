INSERT INTO university_project (id,name,discription,faculty,department ,is_deleted) VALUES (1,'Timetable','automatic create halls and teachers timetable','Engineering','basic sciences' ,0 );
INSERT INTO university_project (id,name,discription,faculty,department ,is_deleted) VALUES (2,'Datacenter','design and build university networking','Engineering','' ,0 );


INSERT INTO   graduate_project (id,year,name ,discription,university_project_id ,is_deleted) VALUES (1, '2020','Timetable website','build website to insert and view data',1 ,0 );
INSERT INTO   graduate_project (id,year,name ,discription,university_project_id ,is_deleted) VALUES (2, '2020','Timetable algorithm','auto generate tables',1 ,0 );
INSERT INTO   graduate_project (id,year,name ,discription,university_project_id ,is_deleted) VALUES (3, '2022','Faculty of Engineering Network design','design Networing schema',2 ,0 );
INSERT INTO   graduate_project (id,year,name ,discription,university_project_id ,is_deleted) VALUES (4,'2022', 'Faculty of Engineering Firewall','setup and config firewall',2 ,0 );

INSERT INTO student (id,name,graduate_project_id ,is_deleted) VALUES (1,'Ali Ahmed',1 ,0 );
INSERT INTO student (id,name,graduate_project_id ,is_deleted) VALUES (2,'Mohamed Ahmed',2 ,0 );
INSERT INTO student (id,name,graduate_project_id ,is_deleted) VALUES (3,'Gasim Zaid',2 ,0 );
INSERT INTO student (id,name,graduate_project_id ,is_deleted) VALUES (4,'Yasser Omar',3 ,0 );
INSERT INTO student (id,name,graduate_project_id ,is_deleted) VALUES (5,'Osman Noor',3 ,0 );
INSERT INTO student (id,name,graduate_project_id ,is_deleted) VALUES (6,'Mahmoud Mohamed ',4 ,0 );

